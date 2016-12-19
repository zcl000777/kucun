var commondlgdata;//和后台交互成功后返回的值   需要谨慎使用
commonform = function(fmid,action){
	initform(fmid, function(result) {
		$.messager.alert('信息','成功！','info');
		doclose();
		commondlgdata = result;
	});
	url = getPath(action); 
	$('#'+fmid).attr("action", url);
};

addform = function (fmid,action){
	commonform(fmid,action);
};

updform=function(fmid,action){
	var row = hasSelectdRow();
	if(row==null)
		return false;
	commonform(fmid,action);
	$('#'+fmid).form('load',row); 
	return true;
};


delform=function(action){
	url = getPath(action);
	var row = hasSelectdRow(); 
	if(row==null)
		return false; 
    $.messager.confirm('确认','确定删除吗?',function(r){  
        if (r){  
    	$.ajax({
			url : url,
			type : 'post',
			async : false,
			data : { 
				"id" : row.id
			},
			success : function(data) {			
				$.messager.alert('信息', '删除成功！', 'info');
			},
			error : function() {
				$.messager.alert('信息', '删除失败！', 'info');
			}
		});  
        }         $('#dg').datagrid('reload'); 
    }); 

};

backform=function(action){
	url = getPath(action);
	var row = hasSelectdRow(); 
	if(row==null)
		return false; 
    $.messager.confirm('确认','确定恢复吗?',function(r){  
        if (r){  
    	$.ajax({
			url : url,
			type : 'post',
			async : false,
			data : { 
				"id" : row.id
			},
			success : function(data) {			
				$.messager.alert('信息', '恢复成功！', 'info');
			},
			error : function() {
				$.messager.alert('信息', '恢复失败！', 'info');
			}
		});  
        }         $('#dg').datagrid('reload'); 
    }); 

};

hasSelectdRow=function (){
	var row = $('#dg').datagrid('getSelected');
	if(!row){
		$.messager.alert('信息', '请选择一行！', 'info');
		return;
	}
	return row;
};