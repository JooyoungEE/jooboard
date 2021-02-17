<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/join.js" charset="UTF-8"></script>
</head>
<body>
	<div class="w3-content w3-center mw650">
		<h1 class="w3-purple w3-padding w3-card-4 w3-margin-top w3-round-large">joo JOIN</h1>
		<form class="w3-col w3-padding w3-card-4 w3-margin-top" id="frm" name="frm">
			<div class="w3-col w3-margin-top">
				<label for="name" class="w3-col l3 m3 w3-right-align w3-padding">회 원 이 름 : </label>
				<div class="w3-col l9 m12 w3-padding">
					<input type="text" class="w3-input w3-border" id="name" name="name" placeholder="이름을 입력하세요!">
				</div>
			</div>
			<div class="w3-col">
				<label for="id" class="w3-col l3 m3 w3-right-align w3-padding">회원 아이디 : </label>
				<div class="w3-col l9 m12 w3-padding">
					<div class="w3-col m9 pdr10">
						<input type="text" class="w3-input w3-border" id="id" name="id" placeholder="아이디를 입력하세요!">
					</div>
				</div>
			</div>
			<div class="w3-col">
				<label for="pw" class="w3-col l3 m3 w3-right-align w3-padding">비 밀 번 호 : </label>
				<div class="w3-col l9 m12 w3-padding">
					<input type="password" class="w3-input w3-border" id="pw" name="pw" placeholder="비밀번호를 입력하세요!">
				</div>
			</div>
			<div class="w3-col">
				<label for="repw" class="w3-col l3 m3 w3-right-align w3-padding">비밀번호 확인 : </label>
				<div class="w3-col l9 m12 w3-padding">
					<input type="password" class="w3-input w3-border" id="repw" name="repw" placeholder="비밀번호를 재입력하세요!">
					<span class="w3-col" id="pwmsg" style="display: none;"></span>
				</div>
			</div>
			<div class="w3-col">
				<label for="mail" class="w3-col l3 m3 w3-right-align w3-padding">회원 이메일 : </label>
				<div class="w3-col l9 m12 w3-padding">
					<input type="text" class="w3-input w3-border" id="mail" name="mail" placeholder="이메일을 입력하세요!">
				</div>
			</div>
			</form>
			<div class="w3-col w3-card-4 w3-margin-top w3-button w3-deep-purple w3-hover-purple" id="jbtn">JOIN</div>
	</div>
</body>
</html>