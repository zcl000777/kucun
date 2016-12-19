//扩展easyui表单的验证
$.extend($.fn.validatebox.defaults.rules, {
	equals : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '字段不匹配.'
	},
	minLength : {
		validator : function(value, param) {
			return value.length >= param[0];
		},
		message : '请输入至少（2）个字符.'
	},
	maxLength : {
		validator : function(value, param) {
			return param[0] >= value.length;
		},
		message : '请输入最大{0}位字符.'
	},
	// 验证汉子
	CHS : {
		validator : function(value) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message : '只能输入汉字'
	},
	// 移动手机号码验证
	mobile : {// value值为文本框中的值
		validator : function(value) {
			var reg = /^1[3|4|5|7|8|9]\d{9}$/;
			return reg.test(value);
		},
		message : '输入手机号码格式不准确.'
	},
	// 国内邮编验证
	zipcode : {
		validator : function(value) {
			var reg = /^[1-9]\d{5}$/;
			return reg.test(value);
		},
		message : '邮编必须是非0开始的6位数字.'
	},
	// qq号
	qq : {
		validator : function(value) {
			var reg = /^[1-9]\d{4,11}$/;
			return reg.test(value);
		},
		message : '输入的QQ号不正确.'
	},
	// 电话号码
	phone : {
		validator : function(value) {
			var reg = /^\d{1,20}$/;
			return reg.test(value);
		},
		message : '输入的电话号码不正确.'
	},
	// 扩展远程验证
	// param的值为[]中值,第三个参数为form的id，之后参数为form中字段名称
	remotex : {
		validator : function(value, param) {
			var _data = {};
			_data[param[1]] = value;
			if (param.length > 3) {
				var _form = $("#" + param[2])[0];
				for (var i = 3; i < param.length; i++) {
					_data[param[i]] = _form[param[i]].value;
					var temp = this.prototype;
				}
			}
			var _2b = $.ajax({
				url : param[0],
				dataType : "json",
				data : _data,
				async : false,
				cache : false,
				type : "post"
			}).responseText;
			return _2b == "true";
		},
		message : ''
	}
});

function complexCol(value, row, index) {
	if (this.field.indexOf('.') == -1)
		return value;
	var fields = this.field.split('.');
	var currentRef = row;
	for (var i = 0; i < fields.length; i++) {
		currentRef = currentRef[fields[i]];
		if (currentRef == null)
			break;
	}

	// value = eval("row['"+field.replace(/\./g,"']['")+"']");
	// alert(tmp);
	return currentRef;
};
function boolCol(value, row, index) {
	if (String(value) == "1") {
		return '<input type="checkbox" checked disable>';
	} else if (String(value) == "0") {
		return '<input type="checkbox" disable>';
	}
};
function testCol(value, row, index) {
	return this.testAttr;
	// return row[this.field];
};

// 格式化日期函数 接收的value为20140331090652 返回格式为2014-03-31 上午 09:06:52
function dateCol(value, row, index) {
	if (value == "" || value == undefined || value.toString().length < 8) {
		return;
	}
	var str = "";
	var year = value.toString().substring(0, 4);
	var month = value.toString().substring(4, 6);
	var date = value.toString().substring(6, 8);
	str += year + "-" + month + "-" + date;

	if (value.toString().length >= 12) {
		var hour = value.toString().substring(8, 10);
		var minute = value.toString().substring(10, 12);
		str += " " + hour + ":" + minute;
	}
	if (value.toString().length >= 14) {
		var second = value.toString().substring(12, 14);
		str += ":" + second;
	}
	return str;
};
// 将字符串格式化为easy控件的时间格式
function formatdate(value) {
	if (value == "" || value == undefined || value.toString().length < 8) {
		return;
	}
	var str = "";
	var year = value.toString().substring(0, 4);
	var month = value.toString().substring(4, 6);
	var date = value.toString().substring(6, 8);
	str += year + "-" + month + "-" + date;

	if (value.toString().length >= 14) {
		var hour = value.toString().substring(8, 10);
		var minute = value.toString().substring(10, 12);
		str += " " + hour + ":" + minute;

		var second = value.toString().substring(12, 14);
		str += ":" + second;
	}

	return str;
};

function stringToDate(value) {
	if (value == "" || value == undefined || value.toString().length < 8) {
		return new Date();
	}
	var yyyy = value.toString().substring(0, 4);
	var mm = value.toString().substring(5, 7);
	var dd = value.toString().substring(8, 10);
	var temp = (Number(mm) - 1).toString();
	if (temp.length == 1) {
		mm = "0" + temp;
	}
	if (value.toString().length >= 11) {
		var hh = value.toString().substring(11, 13);
		var ms = value.toString().substring(14, 16);
		var ss = value.toString().substring(17, 19);
		return new Date(yyyy, mm, dd, hh, ms, ss);
	}
	return new Date(yyyy, mm, dd);
};

function initform(fmid, onSuccess) {
	$('#' + fmid).form({
		onSubmit : function(param) {
			var validate = $(this).form('validate');
			if (validate)
				$.messager.progress({
					text : '正在处理...'
				});// $.blockUI($(".easyui-dialog"));
			return validate;
		},
		success : function(data) {
			$.messager.progress('close');// $.unblockUI($(".easyui-dialog"));
			var result = eval('(' + data + ')');
			if (result.status != 0) {
				$.messager.show({
					title : '错误',
					msg : result.message
				});
			} else {
				if (onSuccess)
					onSuccess(result);
			}
		}
	});
};

// combobox 扩展，增加字典数据支持,增加三个字段：
// codeClass：字典类型代码
// enableNull：是否允许空项
// nullText：空项显示的文本
$.extend($.fn.combobox.defaults, {
	// codeClass: null,
	// enableNull: false,
	// nullText: '(全部)',
	loader : function(param, success, error) {
		var opts = $(this).combobox('options');
		if (!opts.url)
			return false;
		if (opts.codeClass) {
			param = $.extend({
				codeClass : opts.codeClass
			}, param);
		}
		$.ajax({
			type : opts.method,
			url : opts.url,
			data : param,
			dataType : 'json',
			success : function(data) {
				if (data instanceof Array && opts.enableNull) {
					var item = {};
					item[opts.valueField] = null;
					if (opts.nullText)
						item[opts.textField] = opts.nullText;
					else
						item[opts.textField] = "(全部)";
					data.splice(0, 0, item);
				}
				success(data);
			},
			error : function() {
				error.apply(this, arguments);
			}
		});
	}
});
$.extend($.fn.datetimebox.defaults.parser = function(s) {
	if (s == "" || s == undefined || s == null)
		return new Date();
	//var RegExp2 = /^\d{14}$/;

	//if (RegExp2.test(s)) {
	//	var tdate = formatdate(s);
	//	return stringToDate(tdate);
	//}
	//return new Date();
	return stringToDate(s);
});
$.extend($.fn.datebox.defaults.parser = function(s) {
	if (s == "" || s == undefined || s == null)
		return new Date();

	var RegExp2 = /^\d{8}$/;

	if (RegExp2.test(s)) {
		var tdate = formatdate(s);
		return stringToDate(tdate);
	}
	return new Date();
});
function addSeparatorsNF(nStr, inD, outD, sep) {
	nStr += '';
	var dpos = nStr.indexOf(inD);
	var nStrEnd = '';
	if (dpos != -1) {
		nStrEnd = outD + nStr.substring(dpos + 1, nStr.length);
		nStr = nStr.substring(0, dpos);
	}
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(nStr)) {
		nStr = nStr.replace(rgx, '$1' + sep + '$2');
	}
	return nStr + nStrEnd;
};

function moneyCol(value, row, index) {
	if (!value)
		return "0元"; 

	value = value / 100;

	return addSeparatorsNF(value.toFixed(2), '.', '.', ',') + "元";
};

function moneyFix(value){
	value = value / 100;
	return value.toFixed(2);
}
