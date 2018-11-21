<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
	<a href="${pageContext.request.contextPath }/addUser.action">添加用户</a>
	<a href="${pageContext.request.contextPath }/deleteUser.action">删除用户</a>
	<a href="${pageContext.request.contextPath }/updateUser.action">修改用户</a>
	<a href="${pageContext.request.contextPath }/findUser.action">查找用户</a>
  </body>
</html>
