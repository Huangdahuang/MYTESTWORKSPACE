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
		// 要执行文件上传的操作
		// 判断表单是否支持文件上传，即：enctype="multipart/form-data"
		boolean ismultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!ismultipartContent) {
			throw new RuntimeException("your form is not multipart/form-data");
		}

		// 创建一个DiskFileItemFactory工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建一个ServletFileUpload核心操作对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解析request对象，并得到一个表单项的集合
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);

			// 遍历表单项数据
			for (FileItem fileitem : fileItems) {
				if (fileitem.isFormField()) {
					// 普通表单项
					processFormField(fileitem);
				} else {
					// 上传表单项
					processUploadField(fileitem);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传表单项
	 */
	private void processUploadField(FileItem fileitem) {
		// 得到上传文件的名字
		String filename = fileitem.getName();//文件项中的值a.txt
		//得到文件流
		try {
			//文件的输入流
			InputStream is = fileitem.getInputStream();
			
			//创建一个存盘的目录
			String directoryRealPath = this.getServletContext().getRealPath("/upload");
			File storeDirectory = new File(directoryRealPath);
			if(!storeDirectory.exists()) {
				storeDirectory.mkdirs();
			}
			//创建一个文件在storeDirectory下
	        File file = new File(storeDirectory,filename);
			//通过输出流将上传的文件保存到磁盘
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
	 * 普通表单项
	 */
	private void processFormField(FileItem fileitem) {
		String fieldname = fileitem.getFieldName();//字段名
		String fieldvalue = fileitem.getString();//字段值
		System.out.println(fieldname+ "=" + fieldvalue);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
