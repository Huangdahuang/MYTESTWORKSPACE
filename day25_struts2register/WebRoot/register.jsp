<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
  <body>
  <form action="${pageContext.request.contextPath }/register.action" method="post">
			  用户名：<input type="text" name="username" /><br>
			  密码：<input type="password" name="password" /><br>
			  生日：<input type="text" name="birthday" /><br>
	                      爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
	             <input type="checkbox" name="hobby" value="睡觉"/>睡觉
	             <input type="checkbox" name="hobby" value="打飞机"/>打飞机<br>
		            婚否：<input type="checkbox" name="married" value="true"/><br/>
		     <input type="submit" value="注册"/>
  </form>
    
  </body>
</html>
