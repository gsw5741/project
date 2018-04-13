package cn.com.component.service.cm.bean;

import java.io.Serializable;
import java.util.Date;

/**
mynetwork.SYSTEM_MENU**/
public class SystemMenu implements Serializable {
    private String menuId;

    /**菜单名称**/
    private String menuName;

    /**菜单地址**/
    private String menuUrl;

    /**上级菜单ID**/
    private String pMenuId;

    /**显示顺序**/
    private Byte sort;

    /**创建时间**/
    private Date createTime;

    /**修改时间**/
    private Date modifyTime;

    /**菜单类型 1按钮 2导航菜单**/
    private String menuType;

    /**菜单权限**/
    private String menuAuth;

    /**菜单状态 ，1正常启用 2功能关闭**/
    private String menuState;

    /**删除标记 1正常 2删除**/
    private Byte delFlag;

    /**创建人**/
    private String createLoginName;
    /**菜单样式**/
    private String menuCss;
   
    /**上级菜单名称**/
    private String pMenuName;
    
    private Byte leaf;//是否存在子节点
    private static final long serialVersionUID = 1L;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getpMenuId() {
        return pMenuId;
    }

    public void setpMenuId(String pMenuId) {
        this.pMenuId = pMenuId;
    }

 
    public Byte getSort() {
		return sort;
	}

	public void setSort(Byte sort) {
		this.sort = sort;
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

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuAuth() {
        return menuAuth;
    }

    public void setMenuAuth(String menuAuth) {
        this.menuAuth = menuAuth;
    }

    public String getMenuState() {
        return menuState;
    }

    public void setMenuState(String menuState) {
        this.menuState = menuState;
    }

   
    public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }
    
   

	public String getMenuCss() {
		return menuCss;
	}

	public void setMenuCss(String menuCss) {
		this.menuCss = menuCss;
	}
    
	
   
	public String getpMenuName() {
		return pMenuName;
	}

	public void setpMenuName(String pMenuName) {
		this.pMenuName = pMenuName;
	}
    
	public Byte getLeaf() {
		return leaf;
	}

	public void setLeaf(Byte leaf) {
		this.leaf = leaf;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", pMenuId=").append(pMenuId);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", menuType=").append(menuType);
        sb.append(", menuAuth=").append(menuAuth);
        sb.append(", menuState=").append(menuState);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createLoginName=").append(createLoginName);
        sb.append("]");
        return sb.toString();
    }
}