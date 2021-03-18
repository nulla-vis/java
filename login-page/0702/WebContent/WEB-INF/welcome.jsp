<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome.jsp</title>
</head>
<body>
<% String userID = (String)request.getAttribute("userID"); %>
<% if(userID != null){ %>
	<p>ようこそ! <%= userID %></p>
<% } %>
<a href="auth">ログアウト</a>
</body>
</html>