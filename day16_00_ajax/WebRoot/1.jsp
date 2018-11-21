<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/myJS.js"></script>
<title>XMLHttpRequest</title>
</head>
<body>
	<script type="text/javascript">
		window.onload = function() {
			//1:获取XMLHttpRequest对象
			var request = getXMLHttpRequest();
			//4：处理显示结果
			request.onreadystatechange = function() {
			   //alert(request.readyState);
			   if(request.readyState == 4) {
			      alert(request.status);//查看服务器端状态
			      if(request.status == 200) {
			         alert(request.responseText);
			      }
			   }
			}
			//2：建立一个连接
			request.open("get","${pageContext.request.contextPath }/servlet/servletDemo1");
			//3：发送一个请求
            request.send(null);
            //alert(request);
		}
	</script>
</body>
</html>