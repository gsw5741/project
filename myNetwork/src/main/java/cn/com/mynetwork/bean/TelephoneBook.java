package cn.com.mynetwork.bean;

import java.io.Serializable;
import java.util.Date;

/**
mynetwork.TELEPHONE_BOOK**/
public class TelephoneBook extends BootstrapBean implements Serializable {
    private String id;

    /**电话号码**/
    private String telephone;

    /**姓名**/
    private String name;

    /**住址**/
    private String address;

    /**所属群组ID**/
    private String groupId;

    /**创建人ID**/
    private String createId;

    /**创建时间**/
    private Date createTime;

    /**修改时间**/
    private Date modifyTime;
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
  
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", telephone=").append(telephone);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", groupId=").append(groupId);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}