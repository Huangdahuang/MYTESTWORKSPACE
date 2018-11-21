package com.itheima.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private IUserService service = new UserServiceImpl();
	private User user = new User();

	//----------------��������ѯ--------------------------
	private String isUpload;
	
	public String findUserByCondition() throws Exception {
		//����������ѯ�û�             �����״̬�� ��ѡ��--��������     �м���    �޼���
		users = service.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isUpload);
		return SUCCESS;
	}
	
	// ---------------�༭�û��ķ���----------------------
	public String edit() throws Exception {
		// �ж��û��Ƿ�����ѡ���ļ�
		if (upload == null) {
			User dbUser = service.findUserByID(user.getUserID());
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			int res = service.modifyUser(user);
			if(res > 0) {
				return SUCCESS;
			}
		} else {
			// 1.�ļ������·��
			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/files");
			String dir = generateChildPath(filePath);
			// 2.���ɴ�������Ե��ļ���:
			String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;// DSK32JJKSDF2LKDSFSDFJK_uploadFileName;
			// 3.��userģ����ȱ�ٵ����ԣ�����ȥ
			user.setPath(dir);
			user.setFilename(fileName);// ������ļ��������Ǵ���GUID���ļ��������ص�ʱ��Ҫ����
			// 4.�ϴ��ļ�����
			upload.renameTo(new File(filePath + File.separator + dir, fileName));
			// 5.�����û�
			int res = service.modifyUser(user);
			if (res > 0) {
				return SUCCESS;
			}
		}
		return null;
	}

	// -------------��ʾ�༭ҳ��Ķ�������-------------------
	public String editUI() throws Exception {
		// ����userID��ȡ�û�user����,ѹ��ջ��
		user = service.findUserByID(user.getUserID());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}

	// -------------ɾ���û�-------------------------
	public String deleteUserById() throws Exception {

		int res = service.removeUser(user.getUserID());
		if (res > 0) {
			return SUCCESS;
		}
		return null;
	}

	// -------------�ļ�����--------------------------
	private InputStream inputStream;
	private String oldFileName;// ԭʼ�ļ���

	public String downLoad() throws Exception {
		// ��ȡ�û���Ϣ
		User dbUser = service.findUserByID(user.getUserID());
		// ��ȡ�ļ���ŵ�·��
		String filePath = ServletActionContext.getServletContext().getRealPath(
				"/files");
		// ��ԭʼ�ļ�����ֵ
		oldFileName = dbUser.getFilename().substring(
				dbUser.getFilename().indexOf("_") + 1);
		// ���ɸ�һ���ֽ���������ֵ
		inputStream = new FileInputStream(filePath + File.separator
				+ dbUser.getPath() + File.separator + dbUser.getFilename());
		// ���سɹ�
		return SUCCESS;
		// ʣ�µĽ���stream���͵Ľ����ͼ
	}

	// -------------�鿴�û���ϸ��Ϣ--------------------
	public String findUserById() throws Exception {
		// ��ջ����userģ�͸�ֵ
		user = service.findUserByID(user.getUserID());
		// ��userѹջ
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}

	// --------------��ѯ�����û�-----------------------
	private List<User> users;// ���ڴ�Ų�ѯ�����������û�

	public String findAll() throws Exception {
		users = service.findAllUser();
		return SUCCESS;
	}

	// --------------�����û�����-----------------------
	// ���ڱ����ļ���file
	private File upload;
	// �ļ���
	private String uploadFileName;

	public String add() throws Exception {
		// 1.�ļ������·��
		String filePath = ServletActionContext.getServletContext().getRealPath(
				"/files");
		String dir = generateChildPath(filePath);
		// 2.���ɴ�������Ե��ļ���:
		String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;// DSK32JJKSDF2LKDSFSDFJK_uploadFileName;
		// 3.��userģ����ȱ�ٵ����ԣ�����ȥ
		user.setPath(dir);
		user.setFilename(fileName);// ������ļ��������Ǵ���GUID���ļ��������ص�ʱ��Ҫ����
		// 4.�ϴ��ļ�����
		upload.renameTo(new File(filePath + File.separator + dir, fileName));
		// 5.�����û�
		int res = service.saveUser(user);
		if (res > 0) {
			return SUCCESS;
		}
		return null;
	}

	private String generateChildPath(String filePath) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(date);
		File file = new File(filePath, dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	// -------------�û���¼�Ķ�������-------------------
	public String login() throws Exception {
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		// �жϲ鵽���û�û��
		if (dbUser == null) {
			addActionError("�û������ڣ������û������벻ƥ��");
			return "input";//����
		}
		// ��¼�ɹ�
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		return SUCCESS;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}