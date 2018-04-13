package cn.com.component.service.cm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统登录日志
 *
 */
public class SysLoginLog implements Serializable {
    private String loginId;

    /**登录用户名**/
    private String loginUserName;

    /**登录设备（数据字典）**/
    private Byte loginDev;

    /**登录系统ID**/
    private Byte loginSystemId;

    /**登录系统名称**/
    private String loginSystemName;

    /**登录IP**/
    private String loginIp;

    /**登录时间**/
    private Date loginTime;

    /**创建时间**/
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public Byte getLoginDev() {
        return loginDev;
    }

    public void setLoginDev(Byte loginDev) {
        this.loginDev = loginDev;
    }

    public Byte getLoginSystemId() {
        return loginSystemId;
    }

    public void setLoginSystemId(Byte loginSystemId) {
        this.loginSystemId = loginSystemId;
    }

    public String getLoginSystemName() {
        return loginSystemName;
    }

    public void setLoginSystemName(String loginSystemName) {
        this.loginSystemName = loginSystemName;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginId=").append(loginId);
        sb.append(", loginUserName=").append(loginUserName);
        sb.append(", loginDev=").append(loginDev);
        sb.append(", loginSystemId=").append(loginSystemId);
        sb.append(", loginSystemName=").append(loginSystemName);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}