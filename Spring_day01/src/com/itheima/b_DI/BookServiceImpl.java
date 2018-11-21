package com.itheima.b_DI;

public class BookServiceImpl implements BookService {
	// 之前，接口=实现类
	// private BookDao bookDao = new BookDaoImpl();

	// Spring方法：接口+setter方法
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook() {
		this.bookDao.save();
	}
}
