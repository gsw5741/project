package cn.com.component.dubbo.user.dao.business;

import org.apache.ibatis.annotations.Param;

import cn.com.component.user.cm.bean.business.BSystemUserBean;


public interface BSystemUserDao {
	//获取用户详情
	BSystemUserBean selectByUserId(String userId);
	//根据用户登录名获取详情
	BSystemUserBean selectByUserName(String loginName);
	//增加用户角色关联
	int insertUserRole(@Param("roleId")String roleId,@Param("userId")String userId);
	//删除用户角色关联
	int deleteByUserRole(String userId);
	//删除用户角色关联
	int deleteByRoleId(String roleId);
}
