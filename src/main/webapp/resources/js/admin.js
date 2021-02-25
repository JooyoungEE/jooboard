$(function(){
	$('#mebtn').on('click', function(){
		$(location).attr('href', '/admin/adminMember.joo');
	});
	$('#bobtn').on('click', function(){
		$(location).attr('href', '/admin/adminBoard.joo');
	});
});