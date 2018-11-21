package com.itheima.utils;

import java.util.HashMap;
import java.util.Map;

import com.itheima.entity.Book;

public class DButil {
	private static Map<String, Book> books = new HashMap<String, Book>();

	static {
		books.put("1", new Book("1", "金瓶梅", 20, "王瑞欣"));
		books.put("2", new Book("2", "葵花宝典", 30, "古巨基"));
		books.put("3", new Book("3", "九阴真经", 26, "古天乐"));
		books.put("4", new Book("4", "乾坤大罗移", 24, "晨光"));
	}

	// 得到所有书
	public static Map<String, Book> findAllBooks() {

		return books;
	}

	/**
	 * 根据ID查找指定的书名
	 * @param id
	 * @return book
	 */
	public static Book findBookId(String id) {

		return books.get(id);
	}

}
