package com.itheima.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 自定义拦截器
 * 	第一步：创建一个普通类，继承AbstractInterceptor，实现抽象方法intercept
 *  第二步：在struts.xml中配置拦截器
 *  	 1.声明拦截器
 *  		<interceptors>
				<interceptor name="demo1Interceptor" class="com.itheima.web.interceptor.Demo1Interceptor" />
			</interceptors>
		 2.使用拦截器
		 	<!-- 使用自定义拦截器：当配置了任何一个拦截器，默认的拦截器栈就不会在工作了 -->
			<interceptor-ref name="demo1Interceptor"></interceptor-ref>
 * @author zhy
 *
 */
public class Demo1Interceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo1Interceptor拦截器：拦截了-执行动作方法之前");
		//放行：如果有下一个拦截器，就前往下一个拦截器，如果没有了，就到达动作方法
		String rtValue = invocation.invoke();//就是结果视图的名称
		System.out.println("Demo1Interceptor拦截器：拦截了-执行动作方法之后");
		return rtValue;
	}

}
