package com.itheima.demo;

public class WP implements KindWomen {
	private KindWomen kw;

	public WP(KindWomen kw) {
		this.kw = kw;
	}

	@Override
	public void throwEye() {
		kw.throwEye();
	}

	@Override
	public void doSomeThing() {
		kw.doSomeThing();
	}
}
