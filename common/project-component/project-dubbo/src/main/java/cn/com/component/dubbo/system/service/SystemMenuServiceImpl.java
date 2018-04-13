package cn.com.component.dubbo.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.common.util.StringUtil;
import cn.com.component.dubbo.service.BaseService;
import cn.com.component.dubbo.system.dao.SystemMenuDao;
import cn.com.component.dubbo.user.dao.business.BSystemRoleDao;
import cn.com.component.service.cm.bean.SystemMenu;
import cn.com.component.service.cm.bean.SystemRoleMenu;
import cn.com.component.system.cm.service.SystemMenuService;
import cn.com.component.user.cm.bean.business.BSystemRoleBean;

public class SystemMenuServiceImpl extends BaseService implements SystemMenuService {
    @Autowired
	private SystemMenuDao menuDao;
    @Autowired
    private BSystemRoleDao roleDao;
    /**
     * 增加菜单
     */
	@Override
	public ResultVO<Boolean> addMenu(SystemMenu menu) {
		try {
			if(StringUtil.isEmpty(menu.getpMenuId())){
				menu.setpMenuId("0");//没有父级菜单
			}
			menu.setMenuId(UUID.randomUUID().toString());
			menuDao.insertSelective(menu);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(false);
		}
		return new ResultVO<Boolean>(true);
	}
   /**
    * 更新菜单
    */
	@Override
	public ResultVO<Boolean> updateMenu(SystemMenu menu) {
		try {
			if(StringUtil.isEmpty(menu.getpMenuId())){
				menu.setpMenuId("0");//没有父级菜单
			}
			menuDao.updateByPrimaryKeySelective(menu);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(true);
		}
		
		return new ResultVO<Boolean>(true);
	}
    /**
     * 删除菜单
     */
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
	public ResultVO<Boolean> deleteMenu(String menuId) {
		try {
			menuDao.deleteByPrimaryKey(menuId);
			menuDao.deleteMenuRole(menuId);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			rollback();
			return new ResultVO<Boolean>(false);
		}
		return new ResultVO<Boolean>(true);
	}
    /**
     * 获取菜单详情
     */
	@Override
	public ResultVO<SystemMenu> getMenu(String menuId) {
		SystemMenu menu = menuDao.selectByPrimaryKey(menuId);
		if(!"0".equals(menu.getpMenuId())){
			SystemMenu pMenu = menuDao.selectByPrimaryKey(menu.getpMenuId());
			menu.setpMenuName(pMenu.getMenuName());
		}
		return new ResultVO<SystemMenu>(menu);
	}
	/**
	 * 获取下级菜单列表
	 */
	@Override
	public ResultVO<List<SystemMenu>> getMemuList(String pMenuId) {
		List<SystemMenu> list = menuDao.selectMenuByPId(pMenuId);
		return new ResultVO<List<SystemMenu>>(list);
	}
	/**
	 * 下级菜单列表
	 */
	@Override
	public ResultVO<List<Map<String, Object>>> getMenuLevelList(SystemRoleMenu roleMenu) {
		if(StringUtil.isEmpty(roleMenu.getMenuId())){
			roleMenu.setMenuId("0");//显示全部菜单
		}
		List<Map<String,Object>> treelist =Lists.newLinkedList();
		List<String> menuIds = new ArrayList<String>();
		if(!StringUtil.isEmpty(roleMenu.getRoleId())){
			BSystemRoleBean role = roleDao.selectByRoleId(roleMenu.getRoleId());
			menuIds = role.getMenuIds();
		}
		try {
			List<SystemMenu> list = menuDao.selectMenuByPId(roleMenu.getMenuId());
			if(list.size()>0){
				for(SystemMenu menu : list){
					Map<String,Object> map = Maps.newLinkedHashMap();
					map.put("text", menu.getMenuName());
					map.put("href", menu.getMenuUrl());
					map.put("id", menu.getMenuId());
					map.put("parentId", menu.getpMenuId());
					if(!menuIds.isEmpty()){
						if(menuIds.contains(menu.getMenuId())){
							Map<String,String> state = Maps.newLinkedHashMap();
							state.put("checked", "true");
							map.put("state", state);
						}
					}
					//存在下级节点,递归查询子节点
					roleMenu.setMenuId(menu.getMenuId());
					ResultVO<List<Map<String,Object>>> nodesMap = getMenuLevelList(roleMenu);
					if(nodesMap.getObj().size()>0){
						map.put("nodes", nodesMap.getObj());	
					}
					treelist.add(map);
				}
			}
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<List<Map<String,Object>>>(ResMsg.COM_EXCEPTION.getErrorCode(),"出现异常");
		}
		
		
		return new ResultVO<List<Map<String,Object>>>(treelist);
	}
	//检查菜单名是否重复
	@Override
	public ResultVO<Boolean> checkMenuName(SystemMenu menu) {
		int count = menuDao.selectBySearch(menu);
		ResultVO<Boolean> res = new ResultVO<Boolean>(true);
		if(count > 0){
			res.setOk(false);
		}
		return res;
	}
	
    
}
