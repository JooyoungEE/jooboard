<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/login.js"></script>
</head>
<body>
	<div class="w3-content w3-center mw700">
		<h1 class="w3-deep-purple w3-padding w3-card-4">Login</h1>
		<form method="POST" action="/member/loginProc.joo" class="w3-col w3-padding w3-card-4 w3-margin-top" id="frm" name="frm">
			<div class="w3-col w3-margin-top">
				<label for="id" class="w3-col m2 w3-right-align w3-text-grey">I D : &nbsp;</label>
				<input type="text" name="id" id="id" placeholder="아이디를 입력하세요!"
						class="w3-col m9 w3-input w3-border w3-round-4">
			</div>
			<div class="w3-col w3-margin-top">
				<label for="pw" class="w3-col m2 w3-right-align w3-text-grey">P W : &nbsp;</label>
				<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요!"
						class="w3-col m9 w3-input w3-border w3-round-4">
			</div>
			<div class="w3-col w3-margin-top">
				<div class="w3-col w3-button w3-purple w3-hover-deep-purple" id="inbtn">Login</div>
			</div>
		</form>
	</div>
</body>
</html>