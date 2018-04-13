package cn.com.component.system.cm.service;

import java.util.List;

import cn.cn.com.common.vo.ResultVO;
import cn.com.component.service.cm.bean.SystemRoleMenu;
import cn.com.component.user.cm.bean.SystemRole;
import cn.com.component.user.cm.bean.business.BSystemRoleBean;

public interface SystemRoleService {
	//增加角色
    ResultVO<Boolean> addRole(SystemRole role);
    //更新角色
    ResultVO<Boolean> updateRole(SystemRole role);
    //删除角色
    ResultVO<Boolean> deleteRole(String roleId);
    //角色列表
    ResultVO<List<SystemRole>> getRoleList();
    //角色详情
    ResultVO<BSystemRoleBean> getSystemRole(String roleId);
    //批量增加角色菜单
    ResultVO<Boolean> addRoleMenuList(List<SystemRoleMenu> list);
    //获取角色
    ResultVO<SystemRole> getRole(String roleId);
    //检查角色名是否重复
    ResultVO<Boolean> checkRoleName(SystemRole role);
}
