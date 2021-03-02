function allCheck() {
	$('#memb_all').on('click',function(){
        if($("#memb_all").prop("checked")){
            $("[name=memb]").prop("checked",true); 
        }else{
            $("[name=memb]").prop("checked",false); 
        } 
	});
}
 
function oneCheck(mrow)
{
    var allChkBox = $("[name=memb_all]");
    var chkBoxName = $(mrow).attr("name");
 
    if( $(mrow).prop("checked") )
    {
        checkBoxLength = $("[name="+ chkBoxName +"]").length;
        checkedLength = $("[name="+ chkBoxName +"]:checked").length;
        if(checkBoxLength == checkedLength) {
            allChkBox.prop("checked", true);
        } else{
            allChkBox.prop("checked", false);
        }
    }
    else
    {
        allChkBox.prop("checked", false);
    }
}
 
$(function(){
    $("[name=memb_all]").on('click',function(){
        allCheck(this);
    });
    $("[name=memb]").each(function(){
        $(this).on('click',function(){
            oneCheck(this);
        });
    });

	getMembList();
});

function getMembList(){
	$('#memberList').html('');
	var params = new Object();
	params.mno = $('#mno').val();
	
	$.ajax({
		url: '/admin/adminMemberList.joo',
		type: 'post',
		data: params,
		dataType: 'json',
		success: function(data){
			var cnt = data.length;
			for(i = 0; i< cnt; i++){
				var html = '';
				if(cnt>0){
					html += `
						<div class="w3-col w3-border-left w3-border-right">
							<div class="w3-col w3-center w3-hover-lime w3-border-bottom mrow" id="\${data.mno}">
								<div class="w3-col m1 w3-border-right">
									<input type="checkbox" class="w3-center mrow" style="margin-top: 4px;" name="memb" id="memb_${data[i].mno}" value="${data[i].mno}"/>
								</div>
								<div class="w3-col m1 w3-border-right">${data[i].mno}</div>
								<div class="w3-col m2 w3-border-right">${data[i].name}</div>
								<div class="w3-col m2 w3-border-right">${data[i].id}</div>
								<div class="w3-col m3 w3-border-right">${data[i].mail}</div>
								<div class="w3-col m3 w3-border-right" name="div_auth" mno="${data[i].mno}">
									<input type="checkbox" class="w3-center" style="margin-top: 4px;" name="rauth" ${data[i].auth.substring(0, 1) == 1 ? 'checked' : ''}>읽기
									<input type="checkbox" class="w3-center" style="margin-top: 4px;" name="wauth" ${data[i].auth.substring(1, 2) == 1 ? 'checked' : ''}>쓰기
									<input type="checkbox" class="w3-center" style="margin-top: 4px;" name="aauth" ${data[i].auth.substring(2, 3) == 1 ? 'checked' : ''}>관리
								</div>
							</div>
						</div>
					`;	
				$('#memberList').append(html);
				}			
			}
		},
		error: function(request, status, error){}
	});
}

function delMemb(){
	var valueArr = new Array();
	var list = $("input[name=memb]");
	/*
	$.each(list, function(){
		if($(this).is(':checked')){
			
		}	
	});
	*/
	for(var i = 0; i < list.length; i++){
		if($(list[i]).is(':checked')){
			valueArr.push($(list[i]).val());
		}
	}
	if(valueArr.length == 0){
		alert("선택된 회원이 없습니다.");
	} else{
		$.ajax({
			type: 'POST',
			url: '/admin/adminDelMemb.joo',
			data: {valueArr : JSON.stringify(valueArr)},
			datatype: 'json',
			success: function(data){
				if(data=='success'){
					alert("탈퇴 성공");
					getMembList();
				}
			},
			error: function(request, status, error){}
		});		
	}
}

function editMemb(){
	var list = $("[name=div_auth]");
	var array = new Array();
	
	var auth = "";
	$.each(list, function(){
		var rauthChecked = $(this).find('[name=rauth]').is(':checked') ? '1' : '0';
		var wauthChecked = $(this).find('[name=wauth]').is(':checked') ? '1' : '0';
		var aauthChecked = $(this).find('[name=aauth]').is(':checked') ? '1' : '0';
		
		var mno = $(this).attr("mno");
		auth = rauthChecked + wauthChecked + aauthChecked;
		array.push(mno+"_"+auth);
		
	});

/*		for(var i = 0; i <list.length; i++){
			if($(list[i]).is(':checked')){
				authArray.push($(list[i].val()));
			}else{
				authArray.push($(list[i].val()));
			}
		}*/
	
	$.ajax({
		type: 'POST',
		url: '/admin/adminEditMemb.joo',
		data: {authList : JSON.stringify(array)},
		dataType: 'text',
		success: function(data){
			console.log(data);
			if(data == 'success'){
				alert("권한 변경 성공");
				getMembList();
			}
		},
		error: function(request, status, error) {}
	});
}