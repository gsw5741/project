package cn.com.common.exception;

import cn.com.common.message.ResMsg;

public class BusinessException extends RuntimeException {
  
	private static final long serialVersionUID = 1L;
	private ResMsg msg;
    private String errorCode;
    private String errorMsg;
    private String description;
  
	public BusinessException(ResMsg msg) {
		this.msg=msg;
	}
	public BusinessException(String errorCode,String errorMsg) {
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
	}

	public BusinessException(String errorCode,String errorMsg,String description) {
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
		this.description=description;
	}
	public ResMsg getMsg() {
		return msg;
	}

	public void setMsg(ResMsg msg) {
		this.msg = msg;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
