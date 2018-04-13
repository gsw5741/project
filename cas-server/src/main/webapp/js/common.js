
String.prototype.trim = function () {
	return this .replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
}
function StringBuilder()  
{  
   this.data=Array("");  
}  
StringBuilder.prototype.append=function()  
{  
   this.data.push(arguments[0]);  
   return this;  
}  
StringBuilder.prototype.toString=function()  
{  
   return this.data.join("");  
}   
Date.prototype.format = function (format,value) {
	/*
	 * eg:format="yyyy-MM-dd hh:mm:ss";
	 */
	if (!format) {
		format = "yyyy-MM-dd hh:mm:ss";
	}
	if(value==null||value.length<4){
		return '';
	}
	var date={};
	if(!isNaN(value)){
		 date= new Date(value);
	}else{
		var strdata=value.replace(/-/g,"/");
		var index=strdata.indexOf(".");
		if(index>0)
		{
			strdata=strdata.substr(0,index);
		}
		 date= new Date(Date.parse(strdata));
	}
	var o = {
		"M+" : date.getMonth() + 1, // month
		"d+" : date.getDate(), // day
		"h+" : date.getHours(), // hour
		"m+" : date.getMinutes(), // minute
		"s+" : date.getSeconds(), // second
		"q+" : Math.floor((date.getMonth() + 3) / 3), // quarter
		"S" : date.getMilliseconds()
		// millisecond
	};

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (date.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};
/**
 * 判断字符串是否为空。NULL，undefined，只包含空格，以及不包含任何字符的字符串均视为空
 * 
 * @param str
 */
function isEmptyString(str) {
	return (null == str) || (typeof str == 'undefined')
			|| ($.trim(str).length == 0);
}
