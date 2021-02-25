$(function(){
	$('.brow').on('click', function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#bfrm').attr('action', '/board/boardDetail.joo');
		$('#bfrm').submit();
	});
	
	//검색어 조회, 검색버튼
	$('#sbtn').on('click',function(){
		$('#pageNum').val(1);
		
		$('#bfrm').attr('action', '/board/boardList.joo');
		$('#bfrm').submit();
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

function getList(page){
	$('#pageNum').val(page);	
		
	$('#bfrm').attr('action', '/board/boardList.joo');
	$('#bfrm').submit();
}