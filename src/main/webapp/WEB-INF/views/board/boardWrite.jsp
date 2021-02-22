<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/boardWrite.js"></script>
</head>
<body>
	<form method="POST" action="" id="frm">
		<input type="hidden" name="nowPage" value="${PAGE.nowPage}">
	</form>
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-round-large w3-card-4 w3-padding">파일게시판 글쓰기</h1>
		<form class="w3-col w3-margin-top w3-round-large w3-card-4 w3-padding"
			method="POST" action="/board/boardWriteProc.joo" encType="multipart/form-data" id="wfrm" name="wfrm">
			<input type="hidden" name="id" id="id" value="${SID}" >
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">작성자</label>
				<div class="w3-col m9 w3-label">${SID}</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Title</label>
				<div class="w3-col m9">
					<input type="text" name="title" id="title" class="w3-col w3-input w3-border" placeholder="제목을 입력하세요!">
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col m2 w3-right-align w3-label">Body</label>
				<div class="w3-col m9">
					<textarea name="body" id="body" class="w3-col w3-input w3-border" placeholder="내용을 입력하세요!" rows="10" style="resize: none;"></textarea>
				</div>
			</div>
		</form>
		</div>
		<div class="w3-col w3-margin-top w3-margin-bottom w3-card-4">
			<div class="w3-third w3-button w3-red w3-hover-deep-orange" id="cbtn">취 소</div>
			<div class="w3-third w3-button w3-green w3-hover-lime" id="hbtn">Home</div>
			<div class="w3-third w3-button w3-blue w3-hover-aqua" id="wbtn">작 성</div>
		</div>
</body>
</html>