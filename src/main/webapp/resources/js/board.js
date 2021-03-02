$(function(){
	$('.brow').on('click', function(){
		if($('#rauth').val() != 1){
			alert('읽기 권한이 없습니다.');
			return;
		}
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
		if($('#wauth').val() != 1){
			alert('쓰기 권한이 없습니다.');
			return;
		}
		$(location).attr('href', '/board/boardWrite.joo');
	});
	
});

function getList(page){
	$('#pageNum').val(page);	
		
	$('#bfrm').attr('action', '/board/boardList.joo');
	$('#bfrm').submit();
}