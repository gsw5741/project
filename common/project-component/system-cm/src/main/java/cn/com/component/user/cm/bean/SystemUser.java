package cn.com.component.user.cm.bean;

import java.io.Serializable;
import java.util.Date;

import org.omg.IOP.TransactionService;
/**
 * 系统用户
 *
 */
public class SystemUser implements Serializable {
    private String userId;

    /**用户姓名**/
    private String userName;

    /**登录帐户**/
    private String loginName;

    /**盐值，用于加密密码**/
    private String loginPwd;

    /**电话号码**/
    private String userTel;

    /**邮箱地址**/
    private String email;

    /**性别**/
    private String gender;

    /**用户头像地址**/
    private String userImg;

    /**昵称**/
    private String nickName;

    /**生日**/
    private String userBirth;

    /**个性签名**/
    private String signNature;

    /**个人说明**/
    private String description;

    /**创建时间**/
    private Date createTime;

    /**修改时间**/
    private Date modifyTime;

    /**用户状态 1正常 2冻结**/
    private Byte userStatus;
    /**盐值**/
    private String salt;
    /**删除标记 1正常 2删除**/
    private Byte delFlag;
    private String isRememberme;//是否记住我
    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getSignNature() {
        return signNature;
    }

    public void setSignNature(String signNature) {
        this.signNature = signNature;
    }

  

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

   
   
    public Byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Byte userStatus) {
		this.userStatus = userStatus;
	}

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    
	public String getIsRememberme() {
		return isRememberme;
	}

	public void setIsRememberme(String isRememberme) {
		this.isRememberme = isRememberme;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPwd=").append(loginPwd);
        sb.append(", userTel=").append(userTel);
        sb.append(", email=").append(email);
        sb.append(", gender=").append(gender);
        sb.append(", userImg=").append(userImg);
        sb.append(", nickName=").append(nickName);
        sb.append(", userBirth=").append(userBirth);
        sb.append(", signNature=").append(signNature);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}