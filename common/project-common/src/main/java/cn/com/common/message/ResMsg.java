package cn.com.common.message;

public enum ResMsg {
	COM_EXCEPTION("10000", "异常"),
	ADD_EXCEPTION("10001","增加数据异常"),
	DELETE_EXCEPTION("10002","删除数据异常"),
	UPDATE_EXCEPTION("10003","更新数据异常"),
	QUERY_EXCEPTION("10004","查询数据异常"),
	LOGIN_EXCEPTION("10005","用户名或密码错误"),
	EXISTS_EXCEPTION("10006","数据不存在"),
	SESSION_TIME_OUT_EXCEPTION("10007","登录超时"),
	CAS_TICKET_EXCEPTION("10008","验证ticket失败");
	private String errorCode;
	private String errorMsg;

	private ResMsg(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
