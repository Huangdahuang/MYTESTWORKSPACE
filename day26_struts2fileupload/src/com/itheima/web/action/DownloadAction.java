package com.itheima.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载
 * @author Zhihong_Huang
 *
 */
public class DownloadAction extends ActionSupport {
	private InputStream fileInputStream;
	public String download() throws FileNotFoundException {
		//知道文件在哪，找到文件的存储路径
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files");
		//把文件读到一个inputStream
		fileInputStream = new FileInputStream(path);
		//返回一个成功
		return SUCCESS;
		//一个叫做Stream的结果类型把剩下 的东西做完
	}
}
