package cn.com.component.dubbo.user.dao;

import java.util.List;

import cn.com.component.user.cm.bean.SystemRole;

public interface SystemRoleDao {
    /**删除**/
    int deleteByPrimaryKey(String roleId);
    /**增加（非空判断）**/
    int insertSelective(SystemRole record);

    /**查询**/
    SystemRole selectByPrimaryKey(String roleId);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(SystemRole record);
    //角色列表
    List<SystemRole> getRoleList();
    
    int selectBySearch(SystemRole record);

}