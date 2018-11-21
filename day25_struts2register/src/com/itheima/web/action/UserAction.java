package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserSerciveImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û�������صĶ�����
 * 
 * @author Zhihong-Huang
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	// ��һ��service
	private IUserService service = new UserSerciveImpl();

	// ����һ���û���ص�����ģ��
	private User user = new User();

	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String register() {
		// �����û�����ȡ�û����ݿɵ��û�����
		User dbUser = service.findUserByUsername(user.getUsername());
		// �ж϶����Ƿ���ڣ�������ڣ����û����У��򷵻�exists
		if (dbUser != null) {
			return "exists";
		}
		// �����ڣ��򱣴��û���Ϣ
		int res = service.register(user);
		// ִ�н������0
		return res > 0 ? SUCCESS : null;
		// ��򷵻�null
	}
}
