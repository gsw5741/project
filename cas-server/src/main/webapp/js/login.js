login = function() {
	return {
		// 初始化登录界面
		init : function() {
			$("#error").hide();
			$("input[type=text]").bind("keypress",function(ev){   
			    if (ev.keyCode) {
			    	if(ev.keyCode == 13) { 
						login.login();
				 	} 
			    } else if (ev.charCode) {
			    	if(ev.charCode == 13) { 
						login.login();
				 	}
			 	}
			});
			window.setTimeout(function() {
				$("#j_username_input").focus();
			}, 1000);
		},
		
		// 刷新验证码
		refreshCode : function() {
			var random=new Date().getTime()+new Date().getMilliseconds();
			document.getElementById("check_code").src="captcha.htm?"+random;
		},
		
		// 点击登录入口
		sysClick : function(obj) {
			$(".login_box_left li").each(function(i) {
				if ($(this).attr("id") == obj) {
					$(this).attr("class", "on");
					$("#entrySys").val($(this).attr("value"));
				} else {
					$(this).removeAttr("class");
				}
			});
		},

		// 点击登录
		login : function() {
			//var strError = $("#error").html();
			//if (strError.indexOf(BaseMessage.getMessage("infoDoLogin")) >= 0) {
			//	return;
			//}
			//$('#error').hide();
			if (!this._loginValidate()) {
				// 输入验证失败
				return;
			}
			//this._showProcessing();
			$("#j_username").val($("#j_username_input").val());
			$("#loginForm").submit();
		},
		
		// 登录设置
		loginConfirm : function() {
			$.post("login/loginConfirm.shtml", '', function(data) {
				if (data.ok) {
					window.location.href = ctx + "/index.shtml";
				} else {
					// 登录失败
					login._showError("errorLoginFailed");
				}
			});
		},

		// 输入验证
		_loginValidate : function() {
			var userName = $.trim($("#j_username_input").val());
			if (isEmptyString(userName)) {
				this._showError("errorInputRequired", "login.userName");
				return false;
			}
			var password = $.trim($("#j_password").val());
			if (isEmptyString(password)) {
				this._showError("errorInputRequired", "login.password");
				return false;
			}
			/*var validateCode = $.trim($("#jcapatch_code").val());
			if (isEmptyString(validateCode) || validateCode.length != 4) {
				this._showError("errorInputRequired", "login.validateCode");
				return false;
			}*/
			return true;
		},
		
		// 显示错误信息
		_showError : function(errorMessageKey, paramKey) {
			alert(BaseMessage.getMessage(errorMessageKey, paramKey));
			//$("#error").html(BaseMessage.getMessage(errorMessageKey, paramKey));
			//$("#error").show();
		},

		// 显示处理中
		_showProcessing : function() {
			$("#error").html("<img src=\"" + ctx
					+ "/style/images/loading.gif\"/>" + BaseMessage.getMessage("infoDoLogin"));
			$("#error").show();
		},
		changeMouse : function(ccsName) {
			$("#loginBtn").removeAttr("class");
			$("#loginBtn").attr("class", ccsName);
		}
	};
}();

$(document).ready(function() {
	login.init();
	//$("#j_username_input").focus();
});
