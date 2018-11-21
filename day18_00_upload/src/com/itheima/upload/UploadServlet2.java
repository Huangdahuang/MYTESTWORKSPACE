package com.itheima.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Ҫִ���ļ��ϴ��Ĳ���
		// �жϱ��Ƿ�֧���ļ��ϴ�������enctype="multipart/form-data"
		boolean ismultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!ismultipartContent) {
			throw new RuntimeException("your form is not multipart/form-data");
		}

		// ����һ��DiskFileItemFactory������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ����һ��ServletFileUpload���Ĳ�������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ����request���󣬲��õ�һ������ļ���
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);

			// ������������
			for (FileItem fileitem : fileItems) {
				if (fileitem.isFormField()) {
					// ��ͨ����
					processFormField(fileitem);
				} else {
					// �ϴ�����
					processUploadField(fileitem);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ϴ�����
	 */
	private void processUploadField(FileItem fileitem) {
		// �õ��ϴ��ļ�������
		String filename = fileitem.getName();//�ļ����е�ֵa.txt
		//�õ��ļ���
		try {
			//�ļ���������
			InputStream is = fileitem.getInputStream();
			
			//����һ�����̵�Ŀ¼
			String directoryRealPath = this.getServletContext().getRealPath("/upload");
			File storeDirectory = new File(directoryRealPath);
			if(!storeDirectory.exists()) {
				storeDirectory.mkdirs();
			}
			//����һ���ļ���storeDirectory��
	        File file = new File(storeDirectory,filename);
			//ͨ����������ϴ����ļ����浽����
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] b = new byte[1024];
			while((len = is.read()) != -1) {
				fos.write(b,0,len);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	/**
	 * ��ͨ����
	 */
	private void processFormField(FileItem fileitem) {
		String fieldname = fileitem.getFieldName();//�ֶ���
		String fieldvalue = fileitem.getString();//�ֶ�ֵ
		System.out.println(fieldname+ "=" + fieldvalue);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
