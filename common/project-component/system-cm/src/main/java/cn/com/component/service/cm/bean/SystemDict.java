package cn.com.component.service.cm.bean;

import java.io.Serializable;
import java.util.Date;

import cn.com.common.bootstrap.BootstrapBean;

/**
 * 数据字典
 *
 */
/**
 * @author Boss
 *
 */
public class SystemDict extends BootstrapBean implements Serializable {
    private Long dictId;
    /**字典类型ID**/
    private Long dictTypeId;
    /**字典代码**/
    private String code;
    /**字典标签**/
    private String codeLabel;

    /**字典值**/
    private Byte codeValue;

    /**创建人ID**/
    private String createId;

    /**创建人登录名**/
    private String createLoginName;

    /**创建时间**/
    private Date createTime;

    private Byte delFlag;

    private static final long serialVersionUID = 1L;

   

    public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}
    

	public Long getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(Long dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(String codeLabel) {
        this.codeLabel = codeLabel;
    }

    public Byte getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(Byte codeValue) {
        this.codeValue = codeValue;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
    
    

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictId=").append(dictId);
        sb.append(", dictTypeId=").append(dictTypeId);
        sb.append(", code=").append(code);
        sb.append(", codeLabel=").append(codeLabel);
        sb.append(", codeValue=").append(codeValue);
        sb.append(", createId=").append(createId);
        sb.append(", createLoginName=").append(createLoginName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}