<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2中的表单重复提交</title>
  </head>
 <body>
  	<%--使用一个struts2的内置标签 s:token --%>
   	<s:form action="login1">
   		<s:token></s:token>
  		<s:textfield name="name" label="用户名" />
  		<s:submit value="提交"/>
  	</s:form>
  </body>
</html>
