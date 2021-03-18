<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<h2>ログインしてください</h2>
<form action="auth" method="POST">
<input name="id" placeholder="userID"> <input name="password" placeholder="password">
<button>ログイン</button>
</form>
<% String message = (String)request.getAttribute("message"); %>
<% if(message != null){ %>
	<p><%= message %></p>
<% } %>
</body>
</html>