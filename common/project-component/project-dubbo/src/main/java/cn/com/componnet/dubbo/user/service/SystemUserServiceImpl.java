package cn.com.componnet.dubbo.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.common.util.Md5Util;
import cn.com.common.util.StringUtil;
import cn.com.component.dubbo.service.BaseService;
import cn.com.component.dubbo.user.dao.SystemUserDao;
import cn.com.component.dubbo.user.dao.business.BSystemUserDao;
import cn.com.component.user.cm.bean.SystemUser;
import cn.com.component.user.cm.bean.business.BSystemUserBean;
import cn.com.componnet.user.cm.service.SystemUserService;


/**
 * 系统用户业务层
 *
 */
public class SystemUserServiceImpl extends BaseService implements SystemUserService {
    @Autowired
	BSystemUserDao userDao;
    @Autowired
    SystemUserDao tUserDao;
	/**
	 * 根据用户名获取用户信息
	 */
	@Override
	public ResultVO<BSystemUserBean> getUserByName(String loginName) {
		 BSystemUserBean user=userDao.selectByUserName(loginName);
		 if(StringUtil.isEmpty(user)){
			 return new ResultVO<BSystemUserBean>(ResMsg.LOGIN_EXCEPTION.getErrorCode(),ResMsg.LOGIN_EXCEPTION.getErrorMsg());
	
		 }
		 return new ResultVO<BSystemUserBean>(user);
	}
	/**
	 * 注册用户
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
	public ResultVO<Boolean> addUser(SystemUser user) {
		user.setUserId(UUID.randomUUID().toString());
		String salt=Md5Util.generateSalt(6);
		user.setSalt(salt);
		user.setLoginPwd(Md5Util.md5WithSalt(user.getLoginPwd(), salt));
		try {
			tUserDao.insertSelective(user);//注册用户
			userDao.insertUserRole("2", user.getUserId());//增加用户关联角色信息
		} catch (Exception e) {
			rollback();//混滚事务
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.ADD_EXCEPTION.getErrorCode(),"注册用户失败");
			
		}
		return new ResultVO<Boolean>(true);
	}
	/**
	 * 检查用户名是否重复
	 */
	@Override
	public ResultVO<Boolean> checkUser(String loginName) {
		SystemUser user=tUserDao.selectByName(loginName);
		ResultVO<Boolean> res=new ResultVO<Boolean>(false);
		if(StringUtil.isEmpty(user)){
			res.setOk(true);
		}
		return res;
	}
	/**
	 * 获取用户数据
	 */
	@Override
	public ResultVO<Page<SystemUser>> getSystemUserList(PageVO<SystemUser> pageVo) {
		Page<SystemUser> page=pageVo.getPage();
		try {
			List<SystemUser> list=tUserDao.listPageSystemUserList(pageVo);
			int total=tUserDao.getTotal(pageVo.getParam());
			page.setDataList(list);
			page.setTotal(total);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Page<SystemUser>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Page<SystemUser>>(page);
	}
	/**
	 * 注销用户
	 */
	@Override
	public ResultVO<Boolean> updateUser(SystemUser user) {
		try {
			tUserDao.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.UPDATE_EXCEPTION.getErrorCode(),ResMsg.UPDATE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
	/**
	 * 检查邮箱是否注册
	 * 
	 */
	@Override
	public ResultVO<Boolean> checkEmail(String email) {
		SystemUser user=tUserDao.selectByEmail(email);
		ResultVO<Boolean> res=new ResultVO<Boolean>(false);
		if(StringUtil.isEmpty(user)){
			res.setOk(true);
		}
		return res;
	}
	/**
	 * 根据用户ID查询用户
	 */
	@Override
	public ResultVO<BSystemUserBean> getUserByUserId(String userId) {
		BSystemUserBean  user = userDao.selectByUserId(userId);
		 if(StringUtil.isEmpty(user)){
			 return new ResultVO<BSystemUserBean>(ResMsg.EXISTS_EXCEPTION.getErrorCode(),ResMsg.EXISTS_EXCEPTION.getErrorMsg());
	
		 }
		return new ResultVO<BSystemUserBean>(user);
	}

}
