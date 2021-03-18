<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show.jsp</title>
</head>
<body>
<h2>ショッピングカート</h2>
<h3>買いたいものの名前と個数を入力してね。</h3>
<form action="cart" method="POST">
<table>
</tr><td>名前 :</td><td><input name="item"></td><tr>
</tr><td>名前 :</td><td><input type="number" min="0" name="num"></td><tr>
</table>
<button>送信</button>
</form>
<hr/>
<h3>現在のカート内容</h3>
<table>
<% HashMap<String,Integer> cart = (HashMap<String,Integer>)request.getAttribute("cart"); %>
<% if (cart != null) {
	for(String key:cart.keySet()) { %>
<tr><td><%= key %></td><td><%= cart.get(key) %></td></tr>
<% } 

}%>
</table>
<form action="clear">
<button>クリア</button>
</form>

</body>
</html>