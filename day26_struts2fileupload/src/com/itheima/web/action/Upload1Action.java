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
	//表单上提供的字段
	private String username;//普通字段
	private File photo;//上传字段
	//struts2在文件上传时提供的属性
	private String photoFileName;//上传文件名
	private String photoContentType;//上传文件的MIME类型
	
	public String upload() {
		//拿到ServletContext
		ServletContext application = ServletActionContext.getServletContext();
		//调用realPath方法，获取一个根据虚拟目录得到的真实目录
		String filepath = application.getRealPath("/WEB-INF/files");
		//如果这个真实目录不存在，就创建
		File file = new File(filepath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//把photo存过去
		//拷贝:把photo的临时文件复制到指定位置，零食文件还在
		//FileUtils.copyFile(photo, new File(file, photoFileName));
		//剪切 并重命名
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
