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
	// 1���õ�ĳ������Ľڵ�����:��2���������--����������
	public void test1() throws DocumentException {
		SAXReader reader = new SAXReader();// ����һ��XML��������
		Document document = reader.read("src/book.xml");// ��XML�ĵ����ص�document�����У��ڴ棩
		Element root = document.getRootElement();// �õ�һ�����ڵ�
		/*
		 * Element bookNode = root.element("��");
		 * System.out.println(bookNode.getName());
		 */

		List list = root.elements();// �õ���ǰ�ڵ�������ӽڵ�
		Element secondbook = (Element) list.get(1);// �õ���ǰ�ڵ���ı�����
		String name = secondbook.element("����").getText();
		System.out.println(name);
	}

	@Test
	public void test2() throws DocumentException {
		SAXReader reader = new SAXReader();// ����һ��XML��������
		Document document = reader.read("src/book.xml");// ��XML�ĵ����ص�document�����У��ڴ棩
		Element root = document.getRootElement();// �õ�һ�����ڵ�
		treeWalk(root);
	}

	private void treeWalk(Element ele) {
		System.out.println(ele.getName());// �����ǰ�ڵ������
		for (int i = 0; i < ele.nodeCount(); i++) {// ele.nodeCount()�õ���ǰ�ڵ�������ӽڵ�ĸ���
			Node node = ele.node(i);// ȡ���±�Ϊi�Ľڵ�
			if (node instanceof Element) {// �жϵ�ǰ�ڵ��Ƿ�Ϊ��ǩ
				treeWalk((Element) node);// ��nodeǿתΪ��ǩ
			}
		}
	}
}
