package com.itheima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		// 通过事件源对象得到事件源ServletContext
		ServletContext application = sce.getServletContext();
		// 创建一个集合，用于存储session对象
		final List<HttpSession> list =Collections.synchronizedList(new ArrayList<HttpSession>()); 

		// 把集合放到application域中
		application.setAttribute("sessions", list);

		// 创建一个计时器
		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("开始扫描了、、、");
				/*for (HttpSession session : list) {
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l > 5000){//如果时间大于5S，把session销毁并移除
						session.invalidate();
						list.remove(session);
					}
				}*/
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l > 5000){//如果时间大于5S，把session销毁并移除
						session.invalidate();
						System.out.println("session移除了" + session.getId());
						//list.remove(session);
						iterator.remove();
					}
				}
			}
		}, 2000, 5000);// 延迟2S后执行，间隔5S执行一次
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
