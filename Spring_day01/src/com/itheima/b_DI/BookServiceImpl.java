package com.itheima.b_DI;

public class BookServiceImpl implements BookService {
	// ֮ǰ���ӿ�=ʵ����
	// private BookDao bookDao = new BookDaoImpl();

	// Spring�������ӿ�+setter����
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook() {
		this.bookDao.save();
	}
}
