$.dictManager = {
	options : { url:""},
	cache : [],
	callbacks : [],
	loading : [],
	loaded : [],
	loadData : function(cls,target) {
		if(this.loading[cls])
			return;
		this.loading[cls] = true;
		//this.cache[cls] = [];
		$.ajax({
			url : this.options.url,
			data : {codeClass : cls},
			dataType : 'json',
			async: true,
			success : function(data) {
				delete target.loading[cls];
				target.loaded[cls] = true;
				if (data instanceof Array) {
					target.initData(data);
					target.dealCallback(cls);
				}
			},
			complete: function(XHR, TS){
				delete target.loading[cls];
				target.loaded[cls] = true;
			}
		});
	},
	initData : function(rs) {
		if(! (rs instanceof Array))
			return;
		for(var i=0;i<rs.length;i++){
			this.addItem(rs[i]);
		}
	},
	addItem : function(item) {
		if (!this.cache[item.classCode])
			this.cache[item.classCode] = [];
		this.cache[item.classCode][item.code] = item.name;
	},
	addCallback : function(cls, callback) {
		if (!this.callbacks[cls])
			this.callbacks[cls] = [];
		this.callbacks[cls].push(callback);
	},
	dealCallback : function(cls){
		var rs = this.callbacks[cls];
		if (rs instanceof Array){
			for(var i=0;i<rs.length;i++){
				var func = rs[i];
				func();
			}
			delete this.callbacks[cls];
		}
	},
	getCodeValue : function(cls, code, callback) {
		var dict = this.cache[cls];
		if (dict) {
			return dict[code] ? dict[code] : code;
		} else {
			if(this.loaded[cls])
				return code;
			
			if (callback instanceof Function) {
				this.addCallback(cls,callback);
			}
			this.loadData(cls,this);

//			var dict = this.cache[cls];
//			if (dict) {
//				return dict[code] ? dict[code] : code;
//			}
			return code;
		}
	},
};

