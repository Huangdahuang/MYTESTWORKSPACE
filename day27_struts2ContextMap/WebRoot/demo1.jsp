<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>取ActionContext数据</title>
  </head>
  <body>
  	<s:debug/>
  	<%--使用s:property来获取ActionContext中的数据。
  		value属性的取值是一个OGNL表达式。--%>
  	<br/>---------获取大Map中的数据-------------<br/>
  	<%--获取大Map中的数据，在取的时候是#key名称--%>
  	<s:property value="#contextMap"/>
  	<br/>---------获取小Map中的数据-------------<br/>
  	<%--获取大Map中小Map的数据 ,使用#大Map的key.小Map的key--%>
  	<s:property value="#session.sessionMap1"/>
  	<s:property value="#application.applicationMap1"/>
  </body>
</html>
