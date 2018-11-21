package com.huang.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class InsertServlet {
	private  String name;
	private String phoneNum;
	private String email;
	private String host;
	
	public InsertServlet(String name,String phoneNum,String eamil,String host){
		this.name = name ;
		this.phoneNum = phoneNum;
		this.email = eamil;
		this.host = host;
	}
	
	public void insert(){
		try {
			Document doc = DocumentHelper.createDocument();
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("./phone/" +host + ".xml"));
			Element root = null;
			if (!new File("./phone/" +host+ ".xml").exists()) {
				root = doc.addElement("list");
			} else {
				root = document.getRootElement();
			}
			
			Element contactsEle = root.addElement("contacts");
			//添加name
			Element nameEle = contactsEle.addElement("name");
			nameEle.addText(name);
			//添加phoneNum
			Element phoneEle = contactsEle.addElement("phone");
			phoneEle.addText(phoneNum);
			//添加address
			Element eamilEle = contactsEle.addElement("eamil");
			eamilEle.addText(email);
			
			// 创建XMLWriter
			XMLWriter writer = new XMLWriter(new FileOutputStream("./phone/" +host+ ".xml"), OutputFormat.createPrettyPrint());
			if (new File("./phone/" +host + ".xml").exists()) {
				writer.write(document);
			} else {
				writer.write(doc);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
