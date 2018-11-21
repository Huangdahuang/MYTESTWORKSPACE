package com.itheima.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Struts2对EL表达式的改变
 * @author zhy
 *
 */
public class Demo3Action extends ActionSupport {

	//这是动作类中的属性。动作类的对象引用默认是在ValueStack的栈顶
	//private String name = "动作类中的name";
	
	public String execute(){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("name", "请求域中name");//这是在大Map中一个key为request的小Map中的是
		
		ServletContext application = ServletActionContext.getServletContext();
		application.setAttribute("name", "应用域中的name");
		
		//获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		context.put("name", "ActionContext中的name");
		
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
