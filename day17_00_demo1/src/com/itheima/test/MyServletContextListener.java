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
		// ͨ���¼�Դ����õ��¼�ԴServletContext
		ServletContext application = sce.getServletContext();
		// ����һ�����ϣ����ڴ洢session����
		final List<HttpSession> list =Collections.synchronizedList(new ArrayList<HttpSession>()); 

		// �Ѽ��Ϸŵ�application����
		application.setAttribute("sessions", list);

		// ����һ����ʱ��
		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("��ʼɨ���ˡ�����");
				/*for (HttpSession session : list) {
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l > 5000){//���ʱ�����5S����session���ٲ��Ƴ�
						session.invalidate();
						list.remove(session);
					}
				}*/
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l > 5000){//���ʱ�����5S����session���ٲ��Ƴ�
						session.invalidate();
						System.out.println("session�Ƴ���" + session.getId());
						//list.remove(session);
						iterator.remove();
					}
				}
			}
		}, 2000, 5000);// �ӳ�2S��ִ�У����5Sִ��һ��
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
