package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * s:checkboxlist��ǩ��ʹ��
 * 
 * @author zhy
 * 
 */
public class Demo6Action extends ActionSupport {

	// ��ʼ�����õİ����б�
	private String[] hobbyarr = new String[] { "�Է�", "˯��", "д����" };

	// �û��ύ��ʱ�����ݷ�װ����������
	private String hobby;

	public String save() {
		System.out.println(hobby);
		return null;
	}

	public String[] getHobbyarr() {
		return hobbyarr;
	}

	public void setHobbyarr(String[] hobbyarr) {
		this.hobbyarr = hobbyarr;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
