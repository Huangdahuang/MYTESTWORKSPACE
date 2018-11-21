package com.itheima.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.itheima.domain.Book;

public class JsonTest {
    @Test
    /**
     * 使用JSONObject封装对象类型数据
     */
	public void test1() {
	   Book b = new Book();
	   b.setId("1001");
	   b.setName("xyj");
	   b.setPrice(20);
	   
	   String s = JSONObject.fromObject(b).toString();
	   System.out.print(s);
   }
    @Test
    public void test2() {
    	List<Book> list = new ArrayList<Book>();
    	Book b1 = new Book();
 	    b1.setId("1001");
 	    b1.setName("xyj");
 	    b1.setPrice(20);
 	    
 	   Book b2 = new Book();
	   b2.setId("1002");
	   b2.setName("x3j");
	   b2.setPrice(30);
	   
	   Book b3 = new Book();
	   b3.setId("1021");
	   b3.setName("4yj");
	   b3.setPrice(240);
	   
	   list.add(b1);
	   list.add(b2);
	   list.add(b3);
	   
	   String s = JSONArray.fromObject(list).toString();
	   System.out.print(s);
    }
    
    public void test3() {
       
    }
   
    
}
