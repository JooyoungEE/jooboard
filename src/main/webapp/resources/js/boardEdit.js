$(document).ready(function(){
	//취소
	$('#editCbtn').on('click',function(){
		$('#frm').submit();
	});
	
	//홈
	$('#hbtn').on('click',function(){
		$(location).attr('href', '/main.joo');
	});
	
	
	$('#edit').on('click',function(){
		var tTitle = $('#title').val();
		var tBody = $('#body').val();
//		alert('tTitel : ' + tTitle + '\ntBody : ' + tBody);
		
		$('#efrm').submit();
	});
});