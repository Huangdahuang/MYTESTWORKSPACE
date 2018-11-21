<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>EL表达式和OGNL表达式</title>
  </head>
  <body>
    EL表达式：${name}<%--pageContext.findAttribute("name") --%>
    <hr/>
    <%--我们知道就行，开发中不要这么写。
    	当我们不写#号时，它会从值栈的栈顶找对应的属性。如果没有属性，还要去ActionContext中再把value的值作为key去查找
    --%>
    OGNL表达式：<s:property value="name"/>
  	<s:debug/>
  </body>
</html>
