package com.itheima.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Struts2��EL���ʽ�ĸı�
 * @author zhy
 *
 */
public class Demo3Action extends ActionSupport {

	//���Ƕ������е����ԡ�������Ķ�������Ĭ������ValueStack��ջ��
	//private String name = "�������е�name";
	
	public String execute(){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("name", "��������name");//�����ڴ�Map��һ��keyΪrequest��СMap�е���
		
		ServletContext application = ServletActionContext.getServletContext();
		application.setAttribute("name", "Ӧ�����е�name");
		
		//��ȡActionContext����
		ActionContext context = ActionContext.getContext();
		context.put("name", "ActionContext�е�name");
		
		return SUCCESS;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	
}
