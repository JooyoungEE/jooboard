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

	getComment();
});

function getComment(){
	$('#commentList').html('');
	var params = new Object();
	params.sid = $('#sid').val();
	params.bno = $('#bno').val();
	$.ajax({
		type: 'POST',
		url: '/board/boardComment.joo',
		dataType: 'json',
		data: params,
		success: function(data){
			var cnt = data.length;
			for(i = 0; i < cnt; i++){
				var html = '';
				if(cnt > 0){
						/*html += `
								<div>
									<div id="div_${data[i].rno}">
									<table class="table"><h6><strong>${data[i].rwriter}</strong><h6>
						`;		*/			 
						html += "<hr><div style='display: block; text-indent: "+(2*Number(data[i].depth))+"em;'>";
	                    html += "<div id='div_"+data[i].rno+"'><table class='table'><h6><strong>"+data[i].rwriter+"</strong></h6>";
	                    html += "<div 'style='display: block; text-indent: "+(2*Number(data[i].depth))+"em;'>"+data[i].rbody + "<tr><td></td></tr></div>";
						html += "<div class= 'w3-right' style='padding: 2px; margin-bottom: 3px;'>";
						html += "<a href='javascript:addRcomment("+data[i].rbno+","+data[i].rno+");'>댓글달기</a>";
						if(String(params.sid) == String(data[i].rwriter)){
							html += "<a href='javascript:editComment("+data[i].rbno+","+data[i].rno+");'>  수정  </a>";
							html += "<a href='javascript:delComment("+data[i].rbno+","+data[i].rno+");'>삭제</a></div>";
						}
	                    html += "</table></div>";
	                    html += "</div>";
				} else{
					html += "<div>";
	                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
	                html += "</table></div>";
	                html += "</div>";
				}
				if(data[i].rmno == 0){
					$('#commentList').append(html);
				}else{
					$('#div_'+data[i].rmno).after(html);
				}
			}
		},
		error: function(request, status, error){}
	});
}

function addComment(bno){
	var data = new Object();
	data.rbody = $('#comment').val();
	data.bno = $('#bno').val();
	$.ajax({
		type: 'POST',
		url: '/board/addComment.joo',
		data: data,
		success: function(data){
			if(data=='success'){
				getComment();
				$('#rbody').val();
			}
		},
		error: function(request, status, error){}
	});
}

function addRcomment(rbno, rno){
	
	var rhtml = '';
	rhtml += "<textarea style='width: 980px;' rows='3' cols='30' id='rcomment' name='rcomment' style='resize: none;' placeholder='댓글을 입력하세요'></textarea>";
	rhtml += "<a href='javascript:addReComment("+rbno+","+rno+");'>대댓글달기</a>";
	
	if($('#div_'+rno).parents('div:first').find('textarea').length == 0){
		$('#div_'+rno).after(rhtml);	
	}
}
function addReComment(rbno, rno){
	var data = new Object();
	data.rbody = $('#rcomment').val();
	data.rbno = rbno;
	data.rmno = rno;
	$.ajax({
		type: 'POST',
		url: '/board/addReComment.joo',
		data: data,
		success: function(data){
			if(data=='success'){
				getComment();
				$('#rbody').val();
			}
		},
		error: function(request, status, error){}
	});
}

function editComment(rbno, rno){
	var rhtml = '';
	rhtml += "<textarea style='width: 980px;' rows='3' cols='30' id='rcomment' name='rcomment' style='resize: none;' placeholder='댓글을 입력하세요'></textarea>";
	rhtml += "<a href='javascript:editCommentProc("+rbno+","+rno+");'>수정하기</a>";
	
	$('#div_'+rno).after(rhtml);
}

function editCommentProc(rbno, rno){
	addRcomment();
	var data = new Object();
	data.rno = rno;
	data.rbody = $('#rcomment').val();
	$.ajax({
		type: 'POST',
		url: '/board/editComment.joo',
		data: data,
		success: function(data){
			if(data == 'success'){
				getComment();
			}
		},
		error: function(request, status, error){}
	});
}
function delComment(rbno, rno){
	var data = new Object();
	data.rno = rno;
	$.ajax({
		type: 'POST',
		url: '/board/delComment.joo',
		data: data,
		success: function(data){
			if(data=='success'){
				getComment();
			}
		},
		error: function(request, status, error){}
	});
}