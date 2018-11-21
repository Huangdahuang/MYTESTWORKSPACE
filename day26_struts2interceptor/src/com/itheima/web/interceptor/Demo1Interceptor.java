package com.itheima.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * �Զ���������
 * 	��һ��������һ����ͨ�࣬�̳�AbstractInterceptor��ʵ�ֳ��󷽷�intercept
 *  �ڶ�������struts.xml������������
 *  	 1.����������
 *  		<interceptors>
				<interceptor name="demo1Interceptor" class="com.itheima.web.interceptor.Demo1Interceptor" />
			</interceptors>
		 2.ʹ��������
		 	<!-- ʹ���Զ��������������������κ�һ����������Ĭ�ϵ�������ջ�Ͳ����ڹ����� -->
			<interceptor-ref name="demo1Interceptor"></interceptor-ref>
 * @author zhy
 *
 */
public class Demo1Interceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo1Interceptor��������������-ִ�ж�������֮ǰ");
		//���У��������һ������������ǰ����һ�������������û���ˣ��͵��ﶯ������
		String rtValue = invocation.invoke();//���ǽ����ͼ������
		System.out.println("Demo1Interceptor��������������-ִ�ж�������֮��");
		return rtValue;
	}

}
