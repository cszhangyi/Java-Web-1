<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.text.*,java.util.*,java.util.Random"%>
<%
	Random rand = new Random();
	int n = rand.nextInt(1000);
	int m = rand.nextInt(1000);
 %>>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Lawrence</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <font color="red">
    <%
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	out.println("现在的服务器时间："+format.format(new Date()));
    	System.out.println("现在的服务器时间："+format.format(new Date()));
     %>
     <br>
     	第一个随机数：<% out.println(n); %><br>
    	<input type="button" value="点击显示第2个随机数" onclick="javascript:alert('<%= m %>')"/>
     </font>
  </body>
</html>
