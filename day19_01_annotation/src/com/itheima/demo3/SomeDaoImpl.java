package com.itheima.demo3;

public class SomeDaoImpl {
	@MyTest(timeout=1000000000)
	public void testAdd() {
		System.out.println("add方法执行了");
	}

	@MyTest(timeout=1000000000)
	public void testUpdate() {
		System.out.println("testUpdate方法执行了");
	}
}
