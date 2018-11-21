package com.itheima.utils;

import java.util.HashMap;
import java.util.Map;

import com.itheima.entity.Book;

public class DButil {
	private static Map<String, Book> books = new HashMap<String, Book>();

	static {
		books.put("1", new Book("1", "��ƿ÷", 20, "������"));
		books.put("2", new Book("2", "��������", 30, "�ž޻�"));
		books.put("3", new Book("3", "�����澭", 26, "������"));
		books.put("4", new Book("4", "Ǭ��������", 24, "����"));
	}

	// �õ�������
	public static Map<String, Book> findAllBooks() {

		return books;
	}

	/**
	 * ����ID����ָ��������
	 * @param id
	 * @return book
	 */
	public static Book findBookId(String id) {

		return books.get(id);
	}

}
