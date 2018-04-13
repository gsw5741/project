package cn.com.component.user.cm.bean.business;

import java.util.ArrayList;
import java.util.List;

import cn.com.component.service.cm.bean.SystemMenu;
import cn.com.component.user.cm.bean.SystemRole;


public class BSystemRoleBean extends SystemRole {
	private static final long serialVersionUID = 1L;

	private List<SystemMenu> menuList = new ArrayList<SystemMenu>();
	private List<String> menuIds = new ArrayList<String>();

	public List<SystemMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SystemMenu> menuList) {
		this.menuList = menuList;
	}

	public List<String> getMenuIds() {
		if(menuList.size()>0){
			for(SystemMenu menu : menuList){
				menuIds.add(menu.getMenuId());
			}
		}
		return menuIds;
	}

	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}

	
    
	
}
