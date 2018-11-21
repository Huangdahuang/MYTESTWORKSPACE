<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>主页：检查登录的拦截器</title>
	</head>
	<body>
		<%--要想来到本页面（主页），必须得先登录 --%>
		主页<hr/>
		<a href="${pageContext.request.contextPath}/showOther.action">访问另一个页面</a>
	</body>
</html>
