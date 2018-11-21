<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>参数封装</title>
  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/action1.action" method="post">
   		姓名1：<input type="text" name="username" /></br>
   		年龄：<input type="text" name="age" />
   		<input type="submit" value="提交"/>
   </form>
   
   
   <form action="${pageContext.request.contextPath }/action2.action" method="post">
   		姓名2：<input type="text" name="username" /></br>
   		年龄：<input type="text" name="age" />
   		<input type="submit" value="提交"/>
   </form>
   
   <form action="${pageContext.request.contextPath }/action3.action" method="post">
   		姓名2：<input type="text" name="user.username" /></br>
   		年龄：<input type="text" name="user.age" />
   		<input type="submit" value="提交"/>
   </form>
  </body>
</html>
