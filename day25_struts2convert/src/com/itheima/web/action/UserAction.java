package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户操作相关的动作类
 * @author zhy
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private IUserService service = new UserServiceImpl();
	
	//定义一个用户的数据模型，注意：由于使用了模型驱动，我们必须自己实例化对象
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	public String register(){
		//1.根据用户名获取数据库的用户对象
		User dbUser = service.findUserByUsername(user.getUsername());
		//2.判断对象是否存在
		if(dbUser != null){
			//2.1如果存在，则表明用户有了，返回exists的结果视图
			return "exists";
		}
		//3.不存在，保存用户信息
		int res = service.register(user);
		//4.如果执行结果大于0
		if(res > 0){
			return SUCCESS;
		}
		//5.如果不大于0，返回null
		return null;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
