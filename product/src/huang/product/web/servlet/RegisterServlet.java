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
		//��ȡ��֤��
		String ckCode = request.getParameter("ckCode");//��ҳ���л�ȡ�������֤��
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");//��CheckImgServlet�л�ȡͼƬ�е���֤��
		if(!ckCode.equals(checkcode_session)) {//���������֤�벻��
			request.setAttribute("ckCode_msg","��֤�����");//��ʾ��֤�����
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//��ȡ������
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setActiveCode(UUID.randomUUID().toString());
			//����ҵ���߼�
			UserService us = new UserService();
			us.regist(user);
			//�ַ�ת��
			//Ҫ���û���������ʹ�ã����Բ��ܰ��û���Ϣ���浽session��
			//request.getSession().setAttribute("user", user);//���û���Ϣ��װ��Session��
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);//��ת���ɹ�ҳ��
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
