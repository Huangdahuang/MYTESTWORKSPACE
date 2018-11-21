package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserSerciveImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户操作相关的动作类
 * 
 * @author Zhihong-Huang
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	// 顶一个service
	private IUserService service = new UserSerciveImpl();

	// 定义一个用户相关的数据模型
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
		// 根据用户名获取用户数据可的用户对象
		User dbUser = service.findUserByUsername(user.getUsername());
		// 判断对象是否存在，如果存在，则用户已有，则返回exists
		if (dbUser != null) {
			return "exists";
		}
		// 不存在，则保存用户信息
		int res = service.register(user);
		// 执行结果大于0
		return res > 0 ? SUCCESS : null;
		// 缶则返回null
	}
}
