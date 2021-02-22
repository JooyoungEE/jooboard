$(function(){
	$('.brow').on('click', function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#bfrm').attr('action', '/board/boardDetail.joo');
		$('#bfrm').submit();
	});
	
	$('#pbtn a').on('click',function(e){
		e.preventDefault();
		$('#pageNum').val($(this).attr("href"));
		$('#pfrm').submit();
	});
	
	$('#hbtn').on('click',function(){
		$(location).attr('href', '/main.joo');
	});
	
	$('#jbtn').on('click',function(){
		$(location).attr('href', '/member/join.joo');
	});
	
	$('#lbtn').on('click',function(){
		$(location).attr('href', '/member/login.joo');
	});
	
	$('#obtn').on('click',function(){
		$(location).attr('href', '/member/logout.joo');
	});
	
	$('#rbtn').on('click',function(){
		$(location).attr('href', '/board/boardWrite.joo');
	});
	
});