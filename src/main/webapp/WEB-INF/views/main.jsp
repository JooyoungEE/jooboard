<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<script type="text/javascript" src="/resources/css/joo.css"></script>
<script type="text/javascript" src="/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>
</head>
<body>
	<div class="w3-content w3-center mw700">
		<h1 class="w3-teal w3-padding w3-card-4" style="margin-bottom: 5px;">joo BAORD</h1>
		<div class="w3-col">
			<c:if test="${empty sessionScope.SID}">
				<div class="w3-col w3-border-bottom pdb10">
					<span class="w3-col m2 w3-button w3-small w3-blue w3-hover-light-blue w3-right" id="jbtn">Join</span>
					<span class="w3-col m2 w3-button w3-small w3-lime w3-hover-green w3-right" id="lbtn">Login</span>
				</div>
			</c:if>
				<div class="w3-col" id="btnfr">
			<c:if test="${not empty sessionScope.SID}">
					<div class="w3-col w3-border-bottom pdb10">
						<span class="w3-cell m2 w3-button w3-small w3-red w3-hover-light-green w3-right" id="obtn">LogOut</span>
					</div>
			</c:if>
				<div class="w3-center mw100">
					<div class="w3-col m3" style="padding: 0px 10px;">
						<h5 class="w3-col w3-center w3-button w3-purple w3-hover-amber w3-card-4" id="bodbtn">BOARD</h5>
					</div>
				</div>
				</div>
				
		</div>
	</div>
</body>
</html>
