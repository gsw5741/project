package cn.com.cas.auth.credential;

import java.util.HashMap;
import java.util.Map;

import org.jasig.cas.authentication.UsernamePasswordCredential;
/**
 * 自定义用户验证凭证
 * @author Boss
 *
 */
public class CustomAuthCredential extends UsernamePasswordCredential{
	private static final long serialVersionUID = 1L;
	
    private String code;
    
    private String reqService;
    
    private String reqTag;
   
    private Map<String,Object> credentialParam = new HashMap<String,Object>();//认证参数
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReqService() {
		return reqService;
	}

	public void setReqService(String reqService) {
		this.reqService = reqService;
	}

	public String getReqTag() {
		return reqTag;
	}

	public void setReqTag(String reqTag) {
		this.reqTag = reqTag;
	}

	public Map<String, Object> getCredentialParam() {
		return credentialParam;
	}

	public void setCredentialParam(Map<String, Object> credentialParam) {
		this.credentialParam = credentialParam;
	}
    
    
}
