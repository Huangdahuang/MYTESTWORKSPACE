<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itheima.com/function/myfunction" prefix="myfn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>OGNL-Exception</title>
  </head>
  
  <body>
    <%-- EL表达式只能调用静态方法 --%>
    ${myfn:touppoercase("abcdefg") }
    </br>
    <s:property value="OGNL-Expression"/>
    </br>
    <s:property value="'OGNL-Expression'"/>
    </br>
    <s:property value="'OGNL-Expression'.length()"/>
    <hr>
    </br>
    <s:property value="@java.lang.Integer@MAX_VALUE"/>
    <hr>
    </br>
    <s:property value="@java.lang.Math@random()"/>
    
  </body>
</html>


















