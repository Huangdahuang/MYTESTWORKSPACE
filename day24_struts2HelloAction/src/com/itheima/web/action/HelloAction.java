package com.itheima.web.action;
/**
 * Struts2�����Ű���
 * @author Zhihong-Huang
 *
 */
public class HelloAction {//������
	/**
	 * �ڶ������е�ָ���Ķ�������
	 * ������������дҪ��
	 * 	    1������public
	 *      2:����ֵ������String 
	 *      3:����û�в���
	 * @return
	 */
	public String sayHello() {
		System.out.println("HelloAction��sayHello����ִ����");
		return "success";//�������ļ�struts.xml�е�result�е�nameֵ��Ӧ
	}
}
