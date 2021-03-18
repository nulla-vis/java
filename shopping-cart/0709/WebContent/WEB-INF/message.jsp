<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message.jsp</title>
</head>
<body>
<h2>メッセージを書いてね。</h2>
<form action="message" method="POST">
	<input name="message"/>
	<button>送信</button>
</form>
<hr/>
<h3>今までのつぶやつき ：</h3>
<ul>
<!-- ここに入れます -->
<% ArrayList<String> messages = (ArrayList<String>)request.getAttribute("messages"); %>
<% if(messages != null){
	for(String i : messages) { %>
		<li> <%= i %></li>
<%	}
 } %>
</ul>
</body>
</html>