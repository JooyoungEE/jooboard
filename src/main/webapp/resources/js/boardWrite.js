$(function(){
	$('#wbtn').on('click',function(){
		/*
		var tTitle = $('#title').val();
		var tBody = $('#body').val();
		var writer = $('#id').val();
		alert('tTitel : ' + tTitle + '\ntBody : ' + tBody + '\nwriter : ' + writer);
		*/
		$('#wfrm').submit();
	});
	
	$('#hbtn').on('click',function(){
		$(location).attr('href', '/main.joo');
	});
	
	$('#cbtn').on('click',function(){
		$(location).attr('href', '/board/boardList.joo');
	});

});