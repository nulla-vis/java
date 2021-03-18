<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>now.jsp</title>
</head>
<body>
<h2>現在の日時の表示(a)</h2>
<a href="now">今何時</a>
<h2>現在の日時の表示(form)</h2>
<h2>現在の日時の表示</h2>
<form action="now" method="post">
<button>今何時</button>
</form>
<hr/>
<% 
String title = (String)request.getAttribute("title"); 
String strDate = (String)request.getAttribute("strDate"); 
%>
<h1 align="center"><%= title %></h1>
<h2 align="center"><%= strDate %></h2>
</body>
</html>