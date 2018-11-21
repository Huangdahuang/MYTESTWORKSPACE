package com.itheima.web.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

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
	
	
	/**
	 * 在struts2的框架中，它也提供了一个Map<表单的字段名,错误提示>
	 * 我们要做的：
	 * 		往map中存放错误信息
	 * 
	 * 编程式验证:
	 * 	1.动作类必须继承ActionSupport
	 * 	2.重写validate方法
	 * 
	 * validate方法会在动作方法执行之前，进行验证
	 * 
	 * 当重写了validate方法，它会对动作类中的所用动作方法进行验证。
	 * 解决验证所有动作方法的问题：
	 * 	第一种方式：
	 * 		使用@SkipValidation的注解
	 *  第二种方式：
	 *  	定义验证方法的名称：validate+动作名称  动作名称的首字符还要大写
	 
	public void validateRegister(){
		if(StringUtils.isEmpty(user.getUsername())){
			//存入错误信息，直接调用父类的addFieldError方法，存入错误信息。第一个参数是表单name属性的值。第二个参数是错误提示
			addFieldError("username", "请输入用户名");
		}
	}*/
	
	
//	public void validate(){
//		if(StringUtils.isEmpty(user.getUsername())){
//			//存入错误信息，直接调用父类的addFieldError方法，存入错误信息。第一个参数是表单name属性的值。第二个参数是错误提示
//			addFieldError("username", "请输入用户名");
//		}
//	}
	

	public String findAll(){
		return SUCCESS;
	}
	
	public String regist(){
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
