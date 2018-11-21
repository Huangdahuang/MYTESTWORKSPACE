<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>checkboxlist标签的使用</title>
  </head>
  <body>
  	<s:form action="save">
  		<%--checkboxlist：是在表单中生成一些复选框。list的取值是一个OGNL表达式 --%>
  		<s:checkboxlist name="hobby" list="hobbyarr"></s:checkboxlist>
  		<s:submit value="提交"/>
  	</s:form>
  	<%-- <s:debug/> --%>
  </body>
</html>
