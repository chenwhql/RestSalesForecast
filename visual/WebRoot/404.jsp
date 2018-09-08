<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Restaurant Sales Analysis and Forecasting Prototype 404 Error</title>

<style type="text/css">
body,html {
	height: 100%;
	width: 100%;
	padding: 0;
	margin: 0;
	display: block;
	font-family: "Helvetica Neue", Helvetica, Arial, Geneva, sans-serif;
	font-size: 12px;
	color: #e1bd9e;
	background-image: url(<%=basePath%>pages/img/404_bg.jpg);
	background-repeat: repeat-x;
	background-position: 0px -40px;
	overflow: hidden;
}

.content {
	margin-left:auto;
	margin-right: auto;
	margin-top: 55px;
	width: 300px;
	height: 405px;
	background-image: url(<%=basePath%>pages/img/404.png);
	background-repeat: no-repeat;
	padding-top: 375px;
	text-align: center;
	color: #7DBACF;
	font-size: 18px;
	font-weight: 600;
}
.content a{
	color: #FF8A00;
	text-decoration: none;
}
.content a:hover{
	text-decoration: underline;
}

</style>

</head>

<body>
	<div class="content">
		You can <a href="<%=basePath%>index.jsp" >Return HomePage</a>
		<%=basePath%>
	</div>
</body>
</html>