package com.itheima.demo3;

public class SomeDaoImpl {
	@MyTest(timeout=1000000000)
	public void testAdd() {
		System.out.println("add����ִ����");
	}

	@MyTest(timeout=1000000000)
	public void testUpdate() {
		System.out.println("testUpdate����ִ����");
	}
}
