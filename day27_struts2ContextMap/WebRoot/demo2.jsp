<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>取ValueStack中的数据</title>
  </head>
  <body>
    <%--使用s:property标签，获取ValueStack中的元素。
    	value属性的取值是一个OGNL表达式。它只能获取元素中的属性。
    	注意：
    		取ValueStack中的对象属性时，不使用#。
    	它是从栈顶逐个对象查找指定的属性名称。只要找到了，就不再继续查找。
    --%>
    <s:property value="name"/><br/>
    <%--获取ValueStack中指定位置的属性 :
    	详情请见解释图
    --%>
   0-name <s:property value="[0].name" /><br/>
   1-name <s:property value="[1].name" /><br/>
   2-name <s:property value="[2].name" /><br/>
   3-name <s:property value="[3].name" /><br/>
   4-name <s:property value="[4].name" /><br/>
    <%--去栈顶map中的元素 --%>
    <s:property value="s1.name" /><br/>
    
    <%--当s:property什么都不写:
    	默认取栈顶元素
     --%>
    <s:property />
    <%//模拟原理：其实全是ValueStack的findValue和findString
      ValueStack vs = ActionContext.getContext().getValueStack();
      Object obj = vs.findValue("[1].name");
      out.print("<br/>-------------------------<br/>");
      out.print(obj);
    %>
  	<s:debug/>
  </body>
</html>
