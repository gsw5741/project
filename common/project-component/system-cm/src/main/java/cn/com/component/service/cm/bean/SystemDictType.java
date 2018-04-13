package cn.com.component.service.cm.bean;

import java.io.Serializable;

/**
mynetwork.SYSTEM_DICT_TYPE**/
public class SystemDictType implements Serializable {
    private Long typeId;

    /**名称**/
    private String name;

    /**字典代码**/
    private String code;

    /**描述**/
    private String description;

    private static final long serialVersionUID = 1L;


    public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}