package com.itheima.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ�����
 * @author Zhihong_Huang
 *
 */
public class DownloadAction extends ActionSupport {
	private InputStream fileInputStream;
	public String download() throws FileNotFoundException {
		//֪���ļ����ģ��ҵ��ļ��Ĵ洢·��
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files");
		//���ļ�����һ��inputStream
		fileInputStream = new FileInputStream(path);
		//����һ���ɹ�
		return SUCCESS;
		//һ������Stream�Ľ�����Ͱ�ʣ�� �Ķ�������
	}
}
