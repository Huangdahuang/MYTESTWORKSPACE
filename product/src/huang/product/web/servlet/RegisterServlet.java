package huang.product.web.servlet;

import huang.product.domain.User;
import huang.product.exception.UserException;
import huang.product.service.UserService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取验证码
		String ckCode = request.getParameter("ckCode");//从页面中获取输入的验证吗
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");//从CheckImgServlet中获取图片中的验证码
		if(!ckCode.equals(checkcode_session)) {//如果两个验证码不等
			request.setAttribute("ckCode_msg","验证码错误！");//显示验证码错误
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//获取表单数据
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setActiveCode(UUID.randomUUID().toString());
			//处理业务逻辑
			UserService us = new UserService();
			us.regist(user);
			//分发转向
			//要求用户激活后才能使用，所以不能把用户信息保存到session中
			//request.getSession().setAttribute("user", user);//把用户信息封装到Session中
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);//跳转到成功页面
		} catch (UserException e) {
			request.setAttribute("user_msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
