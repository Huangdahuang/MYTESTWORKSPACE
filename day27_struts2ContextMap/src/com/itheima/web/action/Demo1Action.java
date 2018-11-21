package com.itheima.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ����ActionContext������
 * @author zhy
 *
 */
public class Demo1Action extends ActionSupport {

	public String execute(){
		//1.�õ�ActionContext����
		ActionContext context = ActionContext.getContext();//���Ǵӵ�ǰ�̵߳ľֲ������л�ȡ����
		//2.��map�д�������
		context.put("contextMap", "hello contextMap");//������ֱ�Ӵ浽�˴�Map��
		
		//��session�д�����
		//��һ�ַ�ʽ����ȡkeyΪsession��map
		Map<String,Object> sessionAttribute = context.getSession();//�õ�keyֵΪsession��Сmap
		sessionAttribute.put("sessionMap", "hello sessionMap");
		//�ڶ��ַ�ʽ��ֱ��ʹ��ԭʼ��HttpSession����
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionMap1", "hello sessionMap1");
		
		//��ServletContext���д�����
		//��һ�ַ�ʽ����ȡkeyֵΪapplication��map
		Map<String,Object> applicationAttribute = context.getApplication();
		applicationAttribute.put("applicationMap", "hello applicationMap");
		//�ڶ��ַ�ʽ����ȡԭʼServletContext����
		ServletContext application = ServletActionContext.getServletContext();
		application.setAttribute("applicationMap1", "hello applicationMap1");
		
		
		
		
		return SUCCESS;
	}
}
