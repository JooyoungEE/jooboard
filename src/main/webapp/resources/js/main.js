$(document).ready(function(){
	$('.w3-button').click(function(){
		var tmp = $(this).attr('id');
		var spath = '';
		switch(tmp){
			case 'jbtn':
				spath="/member/join.joo";
				break;
			case 'lbtn':
				spath="/member/login.joo";
				break;
			case 'obtn':
				spath="/member/logout.joo";
				break;
			case 'bodbtn':
				spath="/board/boardList.joo";
				break;
		}
		$(location).attr('href', spath);
	});
});