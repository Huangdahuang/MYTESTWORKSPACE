package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ����¼��������,�����汾
 * @author zhy
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		//1.��ȡHttpSession
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2.��ȡsession���еĵ�¼���
		Object obj = session.getAttribute("user");
		//3.�ж��Ƿ��е�¼���
		if(obj == null){
			//�û�û�е�¼
			return "input";
		}
		//4.�û���¼�ˣ�����
		String rtValue = invocation.invoke();
		return rtValue;
	}

}
