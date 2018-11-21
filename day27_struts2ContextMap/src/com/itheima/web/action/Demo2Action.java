package com.itheima.web.action;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * ����VauleStack������
 * @author zhy
 *
 */
public class Demo2Action extends ActionSupport {

	private String name = "̩˹��2";
	
	public String execute(){
		//��ȡValueStack���������
//		//��һ�ַ�ʽ����ȡHttpServletRequest����ͨ�������getAttribute������������ȡ
//		//1.��ȡrequest����
//		HttpServletRequest request = ServletActionContext.getRequest();
//		//2.����key��ȡValueStack���������
//		ValueStack vs1 = (ValueStack)request.getAttribute("struts.valueStack");
//		System.out.println(vs1.hashCode());
//		
//		//�ڶ��ַ�ʽ���Ȼ�ȡActionContext������ȡ��requestMap��Ȼ��ͨ��map��get������ȡ
//		//1.��ȡActionContext����
//		ActionContext context = ActionContext.getContext();
//		//2.��ȡrequestMap
//		Map<String,Object> requestAttribute = (Map<String,Object>)context.get("request");
//		//3.����key��ȡ���������
//		ValueStack vs2 = (ValueStack)requestAttribute.get("struts.valueStack");
//		System.out.println(vs2.hashCode());
//		
//		
//		//�����ַ�ʽ��ʹ��ActionContext����ķ�����ֱ�ӻ�ȡValueStack���������
//		ValueStack vs3 = context.getValueStack();
//		System.out.println(vs3.hashCode());
		
		
		//ջ�Ĳ���
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		//ѹջ����
		vs.push(new Student("̩˹��",21));
		/*
		 * ValueStack����������
		 * setValue(String expr, Object value);
		 * 		String expr:����һ��OGNL���ʽ
		 * 		Object value������Ҫ����������
		 *  �����ݴ浽����ȥ��
		 *  	��expr�Ƿ�ʹ����#
		 *  	���ʹ����#�������ľ���ContextMap��
		 *  	���ûʹ��#�������ľ���ValueStack
		 */
		vs.setValue("#name", "����");//�����ݷŵ�ContextMap�С� key��name	valeu=����
		vs.setValue("name", "����");//��ValueStack�е�һ��name���Ե�ֵ�������ġ����û��һ��name���ԵĶ�Ӧ��setName�������ᱨ��
		
		
		/*
		 *set(String key, Object o);
		 *  String key �� Map��key
		 *  Object o �� map��value
		 *  ���ջ����һ��MapԪ��,ֱ�Ӱ�key��Ϊmap��key,��Object��Ϊmap��value���롣�������ջ����
		 *  ���ջ������һ��MapԪ�أ�����һ��Map���󣬰�key��Ϊmap��key,��Object��Ϊmap��value��ѹ��ջ����
		 */
		vs.set("s1", new Student("����",18));
		vs.push(new Student("test",23));
		vs.set("s2", new Student("aaa",28));
		

		
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
