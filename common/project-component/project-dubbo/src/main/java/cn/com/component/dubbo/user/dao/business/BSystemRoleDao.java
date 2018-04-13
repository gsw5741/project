package cn.com.component.dubbo.user.dao.business;
import java.util.List;

import cn.com.component.service.cm.bean.SystemRoleMenu;
import cn.com.component.user.cm.bean.business.BSystemRoleBean;


public interface BSystemRoleDao {
	//角色详情
	BSystemRoleBean selectByRoleId(String roleId);
	
	//删除角色菜单关联
    int deleteByRoleId(String roleId);
    //批量增加角色菜单关联
    void addRoleMenuList(List<SystemRoleMenu> list);
}
