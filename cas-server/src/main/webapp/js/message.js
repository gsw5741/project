/**
 * 错误信息修改类
 */
var BaseMessage = {
		infoLogin : "登录",
		infoDoLogin : "正在登录...",
		infoNoData : "没有可以显示的数据。",
		infoLoading : "数据加载中，请稍候...",
		errorInputRequired:"{0}不可为空",
		"login.password":"密码",
		"login.userName":"用户名",
		//服务器返回信息修改
		100001:"用户名或者密码错误",
		C_SESSIONTIMEOUT:"100101",
		C_NEEDVCODE:"100102",
		C_VCODEDERROR:"100103",
		400:"参数错误",
		404:"找不到该页面，请联系管理员",
		/**
		 * 返回指定messageKey对应的message
		 * 
		 * @param messageKey
		 *            messageKey
		 * @param paramKey
		 *            参数KEY（字符串或字符串数组）
		 * @returns messageKey对应的message替换参数值后的message字符串
		 */
		getMessage : function(messageKey, paramKey) {
			if(messageKey==null){
				return "无法访问远程服务";
			}
			if($(this).attr(messageKey)==null&&paramKey!=null){
				return paramKey;
			}
			var message = this.getMessageWithoutParam(messageKey);
			if (paramKey==null||paramKey==undefined) {
				return message;
			}
			
			if ($.isArray(paramKey)) {
				$.each(paramKey, function(index, value) {
					var paramValue = biMessage.getMessageWithoutParam(value);
					message = message.replace("{" + index + "}", paramValue);
				});
				return message;
			} else {
				return message.replace("{0}", this.getMessageWithoutParam(paramKey));
			}
		},
		getSessionTimeOutCode:function(){
			return $(this).attr("C_SESSIONTIMEOUT");
		},
		getNeedVcode:function(){
			return $(this).attr("C_NEEDVCODE");
		},
		getVCodeError:function(){
			return $(this).attr("C_VCODEDERROR");
		},
		/**
		 * 返回指定messageKey对应的message
		 * 
		 * @param messageKey
		 *            messageKey
		 * @returns messageKey对应的message,messageKey不存在时直接返回该messageKey
		 */
		getMessageWithoutParam : function(messageKey) {
			var message = $(this).attr(messageKey);
			if (message==null||message==undefined) {
				return messageKey;
			}
			return message;
		}
}