package com.itheima.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * @author Zhihong_Huang
 * 
 */
public class Upload1Action extends ActionSupport {
	//�����ṩ���ֶ�
	private String username;//��ͨ�ֶ�
	private File photo;//�ϴ��ֶ�
	//struts2���ļ��ϴ�ʱ�ṩ������
	private String photoFileName;//�ϴ��ļ���
	private String photoContentType;//�ϴ��ļ���MIME����
	
	public String upload() {
		//�õ�ServletContext
		ServletContext application = ServletActionContext.getServletContext();
		//����realPath��������ȡһ����������Ŀ¼�õ�����ʵĿ¼
		String filepath = application.getRealPath("/WEB-INF/files");
		//��������ʵĿ¼�����ڣ��ʹ���
		File file = new File(filepath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//��photo���ȥ
		//����:��photo����ʱ�ļ����Ƶ�ָ��λ�ã���ʳ�ļ�����
		//FileUtils.copyFile(photo, new File(file, photoFileName));
		//���� ��������
		photo.renameTo(new File(file, photoFileName));
		return null;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}


}
