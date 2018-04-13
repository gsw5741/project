package cn.com.componnet.user.cm.service;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.component.user.cm.bean.SystemUser;
import cn.com.component.user.cm.bean.business.BSystemUserBean;

public interface SystemUserService {
	//根据用户名获取用户信息
    ResultVO<BSystemUserBean> getUserByName(String loginName);
    //注册信息
    ResultVO<Boolean> addUser(SystemUser user);
    //检查登录用户名是否重复
    ResultVO<Boolean>  checkUser(String loginName);
    //检查邮箱是否重复
    ResultVO<Boolean> checkEmail(String email);
     //注册用户列表
    ResultVO<Page<SystemUser>> getSystemUserList(PageVO<SystemUser> pageVo);
    //更新用户
    ResultVO<Boolean> updateUser(SystemUser user);
    
    ResultVO<BSystemUserBean> getUserByUserId(String userId);
}
