package com.itheima.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4j {
	@Test
	// 1、得到某个具体的节点内容:第2本书的书名--》葵花宝典
	public void test1() throws DocumentException {
		SAXReader reader = new SAXReader();// 创建一个XML解析对象
		Document document = reader.read("src/book.xml");// 把XML文档加载到document对象中（内存）
		Element root = document.getRootElement();// 得到一个根节点
		/*
		 * Element bookNode = root.element("书");
		 * System.out.println(bookNode.getName());
		 */

		List list = root.elements();// 得到当前节点的所有子节点
		Element secondbook = (Element) list.get(1);// 得到当前节点的文本内容
		String name = secondbook.element("书名").getText();
		System.out.println(name);
	}

	@Test
	public void test2() throws DocumentException {
		SAXReader reader = new SAXReader();// 创建一个XML解析对象
		Document document = reader.read("src/book.xml");// 把XML文档加载到document对象中（内存）
		Element root = document.getRootElement();// 得到一个根节点
		treeWalk(root);
	}

	private void treeWalk(Element ele) {
		System.out.println(ele.getName());// 输出当前节点的名字
		for (int i = 0; i < ele.nodeCount(); i++) {// ele.nodeCount()得到当前节点的所有子节点的个数
			Node node = ele.node(i);// 取出下标为i的节点
			if (node instanceof Element) {// 判断当前节点是否为标签
				treeWalk((Element) node);// 把node强转为标签
			}
		}
	}
}
