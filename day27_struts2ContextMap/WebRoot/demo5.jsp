<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2中的一些其他标签的使用</title>
  </head>
  <body>
  	<br/>-------s:set------------<br/>
  	<%--s:set标签 
  		value属性：取值是一个OGNL表达式
  		var属性：是一个普通的字符串
  		它是把value属性的值作为value，把var属性的值作为key，把存到ActionContext大map中。
  	--%>
  	<s:set value="'test'" var="str1"/>
  	<br/>-------s:action------------<br/>
  	<%--s:action标签 :
  		name属性是指定一个action动作名称。它并不会真的去执行。
  		executeResult属性指定的是：是否执行action。取值是true/false。默认值：false
  	--%>
  	<s:action name="action1" executeResult="true"/>
  	<br/>-------s:if s:ifelse s:else------------<br/>
  	<%-- 条件判断的标签--%>
  	<s:set value="'S'" var="grade"/>
  	<s:if test="#grade=='D'">差</s:if>
  	<s:elseif test="#grade=='C'">中</s:elseif>
  	<s:else>其他，看着办吧</s:else>
  	<br/>-------s:url------------<br/>
  	<%--s:url标签：
  		value属性：是把值直接输出到页面上
  		action属性：是把动作的请求地址输出到页面上 ${pageContext.request.contextPath}/action1
  		var属性：把action的取值作为value，把var的取值作为key，放到ActionContext中
  		注意：它会自动根据struts配置，来转换后缀名。
  	--%>
  	<s:url value="action1"/>
  	<s:url action="action1" var="url" >
  		<%--把name作为key，把value作为值，绑定到请求连接地址后面。相当于get方式拼接请求参数 
  			注意：
  				name的取值就是一个普通的字符串
  				value的取值是一个OGNL表达式，要想转成字符串请使用''
  		--%>
  		<s:param name="name" value="'张三'"></s:param>
  	</s:url>
  	<br/>
  	<a href="${pageContext.request.contextPath}/action1">来吧 page context</a><br/>
  	<a href="<s:property value='#url' />" >点击 s:url</a>
  	<s:debug/>
  </body>
</html>
