<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
Locale local = request.getLocale();
ResourceBundle bundle = ResourceBundle.getBundle("com.itheima.resources.message",local);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><%=bundle.getString("jsp.login.title") %></title>
  <body>
    <form action="">
    	<%=bundle.getString("jsp.login.username") %>：<input type="text" name="username"><br>
    	<%=bundle.getString("jsp.login.password") %>：<input typr="password" name="password"><br>
    	<input type="submit" value="<%=bundle.getString("jsp.login.submit") %>"/>
    </form>
  </body>
</html>
