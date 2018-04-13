package cn.cn.com.common.vo;

import java.io.Serializable;
/** 
 * 返回结果
 * @author Boss
 *
 * @param <T>
 */
public class ResultVO<T> extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean isOk;//返回结果
    private String errorCode;
    private String errorMsg;
    private T obj;
    
    public ResultVO(boolean _isOk){
    	this.isOk=_isOk;
    }
    public ResultVO(T obj){
    	this.isOk=true;
    	this.obj=obj;
    }
    public ResultVO(String errorCode,String errorMsg){
    	this.isOk=false;
    	this.errorCode=errorCode;
    	this.errorMsg=errorMsg;
    }
    public ResultVO(String errorCode,String errorMsg,T result){
    	this.isOk=false;
    	this.errorCode=errorCode;
    	this.errorMsg=errorMsg;
    	this.obj=result;
    }
    public ResultVO(T obj,String errorMsg){
    	this.obj=obj;
    	this.errorMsg=errorMsg;
    	this.isOk=false;
    }
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
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
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
    

}
