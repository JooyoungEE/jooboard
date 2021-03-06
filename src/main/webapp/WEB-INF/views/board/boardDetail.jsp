<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/boardDetail.js"></script>
</head>
<body>
	<form method="POST" id="frm">
		<input type="hidden" id="bno" name="bno" value="${DATA.bno}">
		<input type="hidden" id="sid" name="sid" value="${SID}">
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-round-large w3-card-4 w3-padding">게시글 상세보기</h1>
		<div class="w3-col w3-margin-top w3-round-large w3-card-4 w3-padding">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align">작성자 : </label>
				<div class="w3-col m9"><span class="pdl20">${DATA.writer}</span></div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align">Title : </label>
				<div class="w3-col m9">
					<div class="w3-col">${DATA.title}</div>
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col m2 w3-right-align w3-label">Body : </label>
				<div class="w3-col m9">
					<div class="w3-col h70">${DATA.body}</div>
				</div>
			</div>
		</div>
		
		<!-- 댓글 -->
		<div class="w3-col w3-margin-top w3-margin-bottom mw750">
			<div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea style="width: 980px" rows="3" cols="30" id="comment" name="comment" style="resize: none;" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <a href="javascript:addComment('${DATA.bno}');" id="rwbtn">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
		</div>
		<div id="commentList">
		</div>
		<div class="w3-col w3-margin-top w3-margin-bottom">
			<div class="w3-col m3 w3-button w3-card-4 w3-red w3-hover-deep-orange" id="cbtn">취 소</div>
	<c:if test="${SID eq DATA.writer}">
			<div class="w3-col m3 w3-button w3-card-4 w3-purple w3-hover-deep-purple w3-right" id="dbtn">삭제</div>
			<div class="w3-col m3 w3-button w3-card-4 w3-blue w3-hover-aqua w3-right" id="ebtn">수정</div>
	</c:if>
			<div class="w3-col m3 w3-button w3-card-4 w3-green w3-hover-lime w3-right" id="hbtn">Home</div>
		</div>
	</div>
	
	</form>
</body>
</html>