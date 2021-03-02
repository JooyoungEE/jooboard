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
<form method="post">
	<div class="w3-col w3-margin-top w3-padding w3-card-4">
		<div class="w3-col w3-left m1" style="margin-bottom: 4px;">
			<input type="checkbox" class="w3-col w3-center w3-left" name="memb_all" id="memb_all" />
		</div>
		<div class="w3-col w3-center w3-border">
			<div class="w3-col m1 w3-light-grey w3-border-right">선택</div>
			<div class="w3-col m1 w3-light-grey w3-border-right">회원번호</div>
			<div class="w3-col m2 w3-light-grey w3-border-right">이름</div>
			<div class="w3-col m2 w3-light-grey w3-border-right">아이디</div>
			<div class="w3-col m3 w3-light-grey w3-border-right">메일</div>
			<div class="w3-col m3 w3-light-grey w3-border-right">권한</div>
		</div>
		<div id = "memberList">
		</div>
			<div>
				<!-- <button class="w3-left" id="dmemb">선택 회원 강제 탈퇴</button> -->
				<a class="w3-left" href="javascript:delMemb(${data.mno});">선택 회원 강제 탈퇴</a>
				<a class="w3-right" href="javascript:editMemb(${data.mno});">선택 회원 권한 변경</a>
			</div>
	</div>
</form>
</body>
</html>