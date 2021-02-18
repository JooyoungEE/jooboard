<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>BoardRedirect</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	/* alert("bno : ${BNO} \n nowPage : ${PAGE.nowPage} \n VIEW : ${VIEW}"); */
	$(function(){
		$('#frm').submit();
	});
</script>
</head>
<body>
	<form method="POST" action="${VIEW}" id="frm">
		<input type="hidden" name="bno" value="${BNO}">
		<input type="hidden" name="nowPage" value="${PAGE.nowPage}">
	</form>
</body>
</html>