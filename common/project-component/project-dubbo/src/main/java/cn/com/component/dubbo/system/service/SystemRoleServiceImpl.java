package cn.com.component.dubbo.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.component.dubbo.service.BaseService;
import cn.com.component.dubbo.user.dao.SystemRoleDao;
import cn.com.component.dubbo.user.dao.business.BSystemRoleDao;
import cn.com.component.dubbo.user.dao.business.BSystemUserDao;
import cn.com.component.service.cm.bean.SystemRoleMenu;
import cn.com.component.system.cm.service.SystemRoleService;
import cn.com.component.user.cm.bean.SystemRole;
import cn.com.component.user.cm.bean.business.BSystemRoleBean;

public class SystemRoleServiceImpl extends BaseService implements SystemRoleService {
	@Autowired
    private SystemRoleDao roleDao;
	@Autowired
	private BSystemRoleDao sysRoleDao;
	@Autowired
	private BSystemUserDao userDao;
	//增加角色
	@Override
	public ResultVO<Boolean> addRole(SystemRole role) {
		try {
			role.setRoleId(UUID.randomUUID().toString());
			roleDao.insertSelective(role);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.ADD_EXCEPTION.getErrorCode(),ResMsg.ADD_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
   //更新角色
	@Override
	public ResultVO<Boolean> updateRole(SystemRole role) {
		try {
			roleDao.updateByPrimaryKeySelective(role);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.UPDATE_EXCEPTION.getErrorCode(),ResMsg.UPDATE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
    //删除角色
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
	public ResultVO<Boolean> deleteRole(String roleId) {
		try {
			userDao.deleteByRoleId(roleId);//删除角色用户关联
			sysRoleDao.deleteByRoleId(roleId);//删除角色菜单关联
			roleDao.deleteByPrimaryKey(roleId);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.DELETE_EXCEPTION.getErrorCode(),ResMsg.DELETE_EXCEPTION.getErrorMsg());
			
		}
		return new ResultVO<Boolean>(true);
	}
   //查询列表
	@Override
	public ResultVO<List<SystemRole>> getRoleList() {
		List<SystemRole> list = new ArrayList<SystemRole>();
		try {
			list = roleDao.getRoleList();
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<List<SystemRole>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		 
		return new ResultVO<List<SystemRole>>(list);
	}
	//角色详情
	@Override
	public ResultVO<BSystemRoleBean> getSystemRole(String roleId) {
		BSystemRoleBean roleBean = sysRoleDao.selectByRoleId(roleId);
		return new ResultVO<BSystemRoleBean>(roleBean);
	}
	//批量增加角色菜单
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
	public ResultVO<Boolean> addRoleMenuList(List<SystemRoleMenu> list) {
		try {
			if(!list.isEmpty()){
				String roleId = list.get(0).getRoleId();
				sysRoleDao.deleteByRoleId(roleId);
				sysRoleDao.addRoleMenuList(list);
			}
		} catch (Exception e) {
			rollback();
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.COM_EXCEPTION.getErrorCode(),"批量增加失败");
		}
		
		return new ResultVO<Boolean>(true);
	}
	//角色详情
	@Override
	public ResultVO<SystemRole> getRole(String roleId) {
		SystemRole role = roleDao.selectByPrimaryKey(roleId);
		return new ResultVO<SystemRole>(role);
	}
	//检查角色名是否重复
	@Override
	public ResultVO<Boolean> checkRoleName(SystemRole role) {
		int count = roleDao.selectBySearch(role);
		ResultVO<Boolean> res = new ResultVO<Boolean>(true);
		if(count > 0){
			res.setOk(false);
		}
		return res;
	}
    
}
