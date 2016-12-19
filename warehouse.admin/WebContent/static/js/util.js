$.blockUI = function(obj){
	if(!obj)
		obj = $("body");
	$("<div class=\"datagrid-mask\" style=\"display:block\"></div>").appendTo(obj);
	var msg=$("<div class=\"datagrid-mask-msg\" style=\"display:block;left:50%\"></div>").html($.fn.datagrid.defaults.loadMsg).appendTo(obj);
	msg.css("marginLeft",-msg.outerWidth()/2);
};

$.unblockUI = function(obj){
	if(!obj)
		obj = $("body");
	obj.children("div.datagrid-mask-msg").remove();
	obj.children("div.datagrid-mask").remove();
};
//将form数据序列化为javascript对象
$.formData = function(jqForm){
	var fields = jqForm.serializeArray();
	var param = {};
	jQuery.each( fields, function(i, field){
		if(field.value && field.value.length > 0)
	  		param[field.name] = field.value;
	});
	return param;
};
//从easyUI的datebox中取得Date数据
$.getDate = function(easyUIDateBox){
	var s = easyUIDateBox.datebox("getValue");
	var t = Date.parse(s);
	if (!isNaN(t)){
		var date = new Date(t);
		return date;
	}else{
		return null;
	}
};

function formats(value,row,index){
	if(value == "" || value == undefined){
		return;
	}
	var year = value.toString().substring(0,4);
	var month = value.toString().substring(4,6);
	var date = value.toString().substring(6,8);
	if(value.toString().length > 8){
		var hour = value.toString().substring(8,10);
		var minute = value.toString().substring(10,12);
		var second = value.toString().substring(12,14);
		var dual;
		if(hour > 12){
			dual = "下午";
		}else{
			dual = "上午";
		}
 		return year + "-" + month + "-" + date + " " + dual + hour + ":" + minute + ":" + second;
	}else{
		return year + "-" + month + "-" + date;
	}
}
