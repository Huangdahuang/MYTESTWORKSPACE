package com.huang.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class RegServlet {
	private String username;
	private String password;
	private String email;
	private int age;
	private String host;

	public RegServlet(String host ,String username, String password,String email,int age) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	/**
	 * 注册功能,向用户账户提交数据
	 * <p>
	 * Title: login
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public void reg() {
		try (RandomAccessFile raf = new RandomAccessFile("./conf/user.dat", "rw");) {
			raf.seek(raf.length());

			byte[] data = username.getBytes("UTF-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);

			data = password.getBytes("UTF-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			
			data = email.getBytes("UTF-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			
			raf.writeInt(age);

			//创建一个空白文档
			Document doc = DocumentHelper.createDocument(); 
			System.out.println("===" + host);
			Element root = doc.addElement("list");
			
			//创建XMLWriter
			XMLWriter writer = new XMLWriter(
						new FileOutputStream("./phone/" + host + ".xml"),OutputFormat.createPrettyPrint()
					);
			writer.write(doc);
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
