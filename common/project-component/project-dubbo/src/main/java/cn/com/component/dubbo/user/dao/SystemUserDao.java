package cn.com.component.dubbo.user.dao;

import java.util.List;

import cn.cn.com.common.vo.PageVO;
import cn.com.component.user.cm.bean.SystemUser;

public interface SystemUserDao {
    /**删除**/
    int deleteByPrimaryKey(String userId);

    /**增加（非空判断）**/
    int insertSelective(SystemUser record);

    /**查询**/
    SystemUser selectByPrimaryKey(String userId);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(SystemUser record);
    /**根据用户名查询**/
    SystemUser selectByName(String userName);
    //根据邮箱获取信息
    SystemUser selectByEmail(String email);
    //用户列表
    List<SystemUser> listPageSystemUserList(PageVO<SystemUser> pageVo);
    //获取总数
    int getTotal(SystemUser param);
}