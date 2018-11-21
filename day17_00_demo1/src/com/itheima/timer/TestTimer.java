package com.itheima.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ����ʱ������
		Timer t = new Timer();
		
		//��������
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
               System.out.println(new Date().toLocaleString());
			}
		}, 2000, 1000);
	}

}
