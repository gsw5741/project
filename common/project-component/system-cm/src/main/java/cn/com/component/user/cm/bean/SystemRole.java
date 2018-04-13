package cn.com.component.user.cm.bean;

import java.io.Serializable;
import java.util.Date;

/**
mynetwork.SYSTEM_ROLE**/
public class SystemRole implements Serializable {
    /**角色ID**/
    private String roleId;

    /**用户ID**/
    private String roleName;

    /**创建时间**/
    private Date createTime;

    /**创建人**/
    private String createLoginName;

    /**角色描述**/
    private String description;

    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
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
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", createTime=").append(createTime);
        sb.append(", createLoginName=").append(createLoginName);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}