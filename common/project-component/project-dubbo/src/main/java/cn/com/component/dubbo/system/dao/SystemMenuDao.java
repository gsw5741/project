package cn.com.component.dubbo.system.dao;

import java.util.List;

import cn.com.component.service.cm.bean.SystemMenu;



public interface SystemMenuDao {
    /**删除**/
    int deleteByPrimaryKey(String menuId);

    /**增加（非空判断）**/
    int insertSelective(SystemMenu record);

    /**查询**/
    SystemMenu selectByPrimaryKey(String menuId);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(SystemMenu record);
    /**
     * 查找下级菜单
     * @param pMenuId
     * @return
     */
    List<SystemMenu> selectMenuByPId(String pMenuId);
    
    int selectBySearch(SystemMenu record);
    //删除菜单与角色关联
    int deleteMenuRole(String menuId);
}