package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.BookDaoImpl;
import com.itheima.domain.Book;

public class BookServiceImpl {
	//创建一个Dao对象
	BookDaoImpl bookDao = new BookDaoImpl();
	
	public List<Book> findAllBooks(){
		try {
			return bookDao.findAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//添加图书
	public void addBook(Book book){
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book findBookById(String id) {
		try {
			return bookDao.findBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(String id) {
		try {
			bookDao.delBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delAllBooks(String[] ids) {
		try {
			bookDao.delAllBooks(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
