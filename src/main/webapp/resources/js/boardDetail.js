$(function(){
	$('#ebtn').on('click', function(){
		$('#frm').attr('action', '/board/boardEdit.joo').submit();
	});	

	$('#dbtn').on('click',function(){
		$('#frm').attr('action', '/board/boardDel.joo').submit();
	});
	
	$('#hbtn').on('click',function(){
		$(location).attr('href', '/main.joo');
	});
	
	$('#cbtn').on('click',function(){
		$(location).attr('href', '/board/boardList.joo');
	});

});