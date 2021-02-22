<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/board.js"></script>
</head>
<body>
	<form method="POST" action="" id="bfrm">
		<input type="hidden" name="bno" id="bno" value="">
	</form>
	<div class="w3-content mw800">
		<div class="w3-col w3-center w3-card-4">
			<div class="w3-col w3-pink w3-padding">joo 파일 게시판</div>
			
			<div class="w3-col">
				<div class="w3-col m1 w3-deep-orange w3-hover-lime w3-button w3-tiny w3-left" id="hbtn">home</div>
	<c:if test="${not empty SID}">
				<div class="w3-col m1 w3-red w3-hover-deep-orange w3-button w3-tiny w3-right" id="obtn">logout</div>
				<div class="w3-col m1 w3-deep-purple w3-hover-deep-orange w3-button w3-tiny w3-right" id="rbtn">write</div>
	</c:if>
	<c:if test="${empty SID}">
				<div class="w3-col m1 w3-deep-purple w3-hover-deep-orange w3-button w3-tiny w3-right" id="lbtn">login</div>
				<div class="w3-col m1 w3-purple w3-hover-deep-orange w3-button w3-tiny w3-right" id="jbtn">join</div>
	</c:if>
				<div class="w3-rest w3-purple" style="opacity: 0.7; height: 31px;"> </div>
			</div>
		</div>
		
		<div class="w3-col w3-margin-top w3-padding w3-card-4">
			<div class="w3-col w3-center w3-border w3-margin-top">
				<div class="w3-col m1 w3-light-grey w3-border-right">글번호</div>
				<div class="w3-col m6 w3-light-grey w3-border-right">글제목</div>
				<div class="w3-col m2 w3-light-grey w3-border-right">작성자</div>
				<div class="w3-col m3 w3-light-grey w3-border-right">작성일</div>
			</div>
	<c:if test="${not empty boardList}">
				<div class="w3-col w3-border-left w3-border-right w3-margin-bottom">
		<c:forEach var="data" items="${boardList}">
					<div class="w3-col w3-center w3-hover-lime w3-border-bottom brow" id="${data.bno}">
						<div class="w3-col m1 w3-border-right">${data.bno}</div>
						<div class="w3-col m6 w3-border-right w3-left-align pdl10">${data.title}</div>
						<div class="w3-col m2 w3-border-right">${data.writer}</div>
						<div class="w3-col m3 w3-border-right">${data.bdate}</div>
					</div>
		</c:forEach>
				</div>
	</c:if>
		</div>
		
		<div class="w3-col w3-center w3-margin-top w3-margin-bottom" id="pbtn">
			<c:if test="${paging.prev}">
				<a href="${paging.startPage - 1 }">&laquo;</a>
			</c:if>
			<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage }">
				&nbsp;<a href="${num}">${num}</a>&nbsp;
			</c:forEach>
			<c:if test="${paging.next}">
				<a id="next" href="${paging.endPage + 1 }">&raquo;</a>
			</c:if>
		</div>
	
		<form id="pfrm" name="pfrm" action="/board/boardList.joo" method="POST">
			<input type="hidden" id="pageNum" name="pageNum" value="${paging.cri.pageNum }">
			<input type="hidden" id="amount" name="amount" value="${paging.cri.amount }">
		</form>
		
	</div>
</body>
</html>