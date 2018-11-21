package huang.product.service;

import java.sql.SQLException;

import huang.product.dao.UserDao;
import huang.product.domain.User;
import huang.product.exception.UserException;
import huang.product.utils.SendJMail;

public class UserService {
	// �������ݲ�
	UserDao ud = new UserDao();

	public void regist(User user) throws UserException {
		try {
			ud.addUser(user);// �û�ע��

			String emailMsg = "ע��ɹ�����<a href='http://223.240.3.67:8080/product/activeServlet?activeCode="
					+ user.getActiveCode() + "'>����</a>���¼";
			SendJMail.sendMail(user.getEmail(), emailMsg);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("ע��ʧ�ܣ�");
		}
	}

	public void activeUser(String activeCode) throws UserException {
		// ���ݼ���������û�
		try {
			User user = ud.findUserByActiveCode(activeCode);
			if (user != null) {
				// �����û�
				ud.activeCode(activeCode);
				return;
			}
			throw new UserException("����ʧ�ܣ�~");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("����ʧ�ܣ�~");
		}
	}

	public User login(String username, String password) throws UserException {
		User user = null;
		try {
			user = ud.findUserByUserNameAndPassword(username, password);
			if (user == null) {
				throw new UserException("�û��������������");
			}
			if (user.getState() == 0) {
				throw new UserException("�û�Ϊ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("�û��������������");
		}
		return user;
	}

	public User findUserById(String id) throws UserException {
		try {
			return ud.findUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("�û�����ʧ�ܣ�");
		}
		
	}

	public void modifyUser(User user) throws UserException {
		try {
			ud.modifyUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("�޸�ʧ��");
		}
		
	}
}
