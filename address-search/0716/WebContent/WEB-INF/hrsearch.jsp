<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.heartrails.Area, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>郵便番号からの住所検索</title>
<style>
#wrapper {
	display: flex;
	width: 100%;
}
#list {
	width: 30%;
	height: 50vh;
	overflow: auto;
}
#list > ul {
	list-style-type: none;
}
#detail {
	width: 90%;
	height: 50vh;
}
#detail tr,#detail td,#detail th {
	border: 1px solid gray;
}
#detail th{
	width: 30%;
	background-color: lightgray;
}
</style>
</head>
<body>
<h2>住所の一部を入力してください</h2>
<form action="hrsearch" method="POST">
	<input name="key" value=""/>
	<button>送信</button>
	<a href="hrsearch">リセット</a>
</form>
<% if(request.getParameter("key") != null) { %>
<h3>「<%= request.getParameter("key") %>」の検索結果</h3>
<% } %>
<% ArrayList<Area> result = (ArrayList<Area>)session.getAttribute("result"); %>
<% if(result != null) { %>
<div id="wrapper">
	<div id="list">
	<ul>
	<% for (Area a : result) { 
	request.setAttribute("area", a.hashCode());%>
	<%-- aを取得するためのhrsearchへのリンクを出力 --%>
	<li><a href="hrsearch?area=<%= a.hashCode() %>"><%= a.getPostal() %></a>
	<% } %>
	</ul>
	</div>
	<% Area detail = (Area)request.getAttribute("detail"); %>
	<% if (detail != null) { %>
	<table id="detail">
	<tr><th>郵便番号</th><td><%= detail.getPostal() %></td></tr>
	<tr><th>都道府県</th><td><%= detail.getPrefecture() %></td></tr>
	<tr><th>市区名</th><td><div>
		<ruby><%= detail.getCity() %><rt><%= detail.getCity_kana() %></rt></ruby>
		</div></td></tr>
	<tr><th>町域名</th><td><div>
		<ruby><%= detail.getTown() %><rt><%= detail.getTown_kana() %></rt></ruby>
		</div></td></tr>
	<tr><th>緯度</th><td><%= detail.getX() %></td></tr>
	<tr><th>経度</th><td><%= detail.getY() %></td></tr>
	</table>
	<% } %>
</div>

<% } %>
</body>
</html>