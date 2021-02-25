<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>AdminMember</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/adminMember.js"></script>
</head>
<body>
	<div class="w3-col w3-margin-top w3-padding w3-card-4">
		<div class="w3-col w3-center w3-border w3-margin-top">
			<div class="w3-col m2 w3-light-grey w3-border-right">회원번호</div>
			<div class="w3-col m2 w3-light-grey w3-border-right">이름</div>
			<div class="w3-col m2 w3-light-grey w3-border-right">아이디</div>
			<div class="w3-col m4 w3-light-grey w3-border-right">메일</div>
			<div class="w3-col m2 w3-light-grey w3-border-right">권한</div>
		</div>
	<c:if test="${not empty memberList}">
			<div class="w3-col w3-border-left w3-border-right w3-margin-bottom">
		<c:forEach var="data" items="${memberList}">
			<div class="w3-col w3-center w3-hover-lime w3-border-bottom mrow" id="${data.mno}">
				<div class="w3-col m2 w3-border-right">${data.mno}</div>
				<div class="w3-col m2 w3-border-right">${data.name}</div>
				<div class="w3-col m2 w3-border-right">${data.id}</div>
				<div class="w3-col m4 w3-border-right">${data.mail}</div>
				<div class="w3-col m2 w3-border-right">${data.auth}</div>
			</div>
		</c:forEach>
			</div>
	</c:if>
	</div>
</body>
</html>