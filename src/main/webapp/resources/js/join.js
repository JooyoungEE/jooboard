$(document).ready(function(){

	// 비밀번호 확인 기능
	$('#repw').keyup(function(){
		var spw = $('#pw').val();
		var srepw = $(this).val();
		if(spw == srepw){
			$('#pwmsg').css('color', 'green');
			$('#pwmsg').html('*** 비밀번호가 일치합니다! ***');
			$('#pwmsg').stop().show();
			setTimeout(hidePwTag, 1500);
		} else {
			$('#pwmsg').css('color', 'red');
			$('#pwmsg').html('### 비밀번호가 다릅니다! ###');
			$('#pwmsg').stop().show();
		}
	});
	
	// 비밀번호 정규식 검사
	$('#pw').keyup(function(){
		
		var spw = $(this).val();
		var pattern = /^.*(?=^[a-zA-Z0-9#@!$%&-_*]{8,})(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#@!$%&-_*]).*$/;
		var result = pattern.test(spw);
		if(result){
			$(this).removeClass('w3-pale-red');
			$(this).addClass('w3-teal');
		} else {
			$(this).removeClass('w3-teal');
			$(this).addClass('w3-pale-red');
		}
	});
	
	// 회원가입처리 버튼
	$('#jbtn').click(function(){
		var sname = $('#name').val();
		var sid = $('#id').val();
		var spw = $('#pw').val();
		var smail = $('#mail').val();
		
		if(!(sname && sid && spw && smail)){
			return;
		}
		
		$('#frm').attr('method', 'POST'); 
		$('#frm').attr('action', '/member/joinProc.joo'); 
		
		$('#frm').submit();
		
	});
});
