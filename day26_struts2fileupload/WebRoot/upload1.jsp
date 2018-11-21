<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Struts2文件上传</title>
      </head>
  
  <body>
	    <s:form action="upload.action" enctype="multipart/form-data">
	    	<s:textfield name="username" label="用户名"></s:textfield>
	    	<s:file name="photo" label="照片"></s:file>
	    	<s:submit value="提交"></s:submit>
	    </s:form>
  </body>
</html>
