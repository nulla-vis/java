<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calc.jsp</title>
</head>
<body>
<h2>整数を2つを入力してください。</h2>
<form action="calc" method="POST">
<input name="xStr"> <input name="yStr">
<button>送信</button>
</form>
<hr/>
<%
double [] result = (double [])request.getAttribute("result");
%>
<% if(result != null){ %>
入力 :  x = <%= request.getParameter("xStr") %>, y = <%= request.getParameter("yStr") %>
<table>
<tr><th>加算</th><td><%= result[2] %></td></tr>
<tr><th>減算</th><td><%= result[3] %></td></tr>
<tr><th>乗算</th><td><%= result[4] %></td></tr>
<tr><th>割算</th><td><%= result[5] %></td></tr>
</table>
<% } %>
</body>
</html>