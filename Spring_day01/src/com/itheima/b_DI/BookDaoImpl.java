package com.itheima.b_DI;

public class BookDaoImpl implements BookDao {

	@Override
	public void save() {
		System.out.println("di add book");
	}

}
