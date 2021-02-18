<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>BoardEdit</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/boardEdit.js"></script>
</head>
<body>
	<form method="POST" action="/board/boardDetail.joo" id="frm" class="edit">
		<input type="hidden" name="bno" value="${LIST[0].bno}">
		<input type="hidden" name="nowPage" value="${PAGE.nowPage}">
	</form>
	
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-round-large w3-card-4 w3-padding">게시판 글수정</h1>
		<form class="w3-col w3-margin-top w3-round-large w3-card-4 w3-padding"
			method="POST" action="/board/boardEditProc.joo" encType="multipart/form-data" id="efrm" name="efrm">
			
			<input type="hidden" id="ttitle" value="${LIST[0].title}">
			<input type="hidden" id="tbody" value="${LIST[0].body}">
			<input type="hidden" name="bno" value="${LIST[0].bno}">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">작성자</label>
				<div class="w3-col m9 w3-label">${LIST[0].writer}</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Title</label>
				<div class="w3-col m9">
					<input type="text" name="title" id="title" class="w3-col w3-input w3-border" placeholder="제목을 입력하세요!" value="${LIST[0].title}">
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col m2 w3-right-align w3-label">Body</label>
				<div class="w3-col m9">
					<textarea name="body" id="body" class="w3-col w3-input w3-border" placeholder="내용을 입력하세요!" rows="10" style="resize: none;">${LIST[0].body}</textarea>
				</div>
			</div>
		</form>
		<div class="w3-col w3-margin-top w3-margin-bottom w3-card-4">
			<div class="w3-third w3-button w3-red w3-hover-deep-orange" id="editCbtn">취 소</div>
			<div class="w3-third w3-button w3-green w3-hover-lime" id="hbtn">Home</div>
			<div class="w3-third w3-button w3-blue w3-hover-aqua" id="edit">edit</div>
		</div>
	<!-- 	<footer class="w3-container w3-padding">
			<div class="w3-half">
	 			<div class="w3-col w3-button w3-border w3-round-medium w3-border-red w3-hover-red closeBtn">close</div>
			</div>
			<div class="w3-half">
	 			<div class="w3-col w3-button w3-border w3-round-medium w3-border-blue w3-hover-blue" id="delBtn">삭 제</div>
			</div>
		</footer> -->
	</div>
</body>
</html>