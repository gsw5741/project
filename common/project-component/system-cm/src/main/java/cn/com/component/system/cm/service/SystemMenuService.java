package cn.com.component.system.cm.service;

import java.util.List;
import java.util.Map;

import cn.cn.com.common.vo.ResultVO;
import cn.com.component.service.cm.bean.SystemMenu;
import cn.com.component.service.cm.bean.SystemRoleMenu;

public interface SystemMenuService {
	//增加菜单
   ResultVO<Boolean> addMenu(SystemMenu menu);
   //更新菜单
   ResultVO<Boolean> updateMenu(SystemMenu menu);
   //删除菜单
   ResultVO<Boolean> deleteMenu(String  menuId);
   //获取菜单详情
   ResultVO<SystemMenu> getMenu(String menuId);
   //下级菜单列表
   ResultVO<List<SystemMenu>> getMemuList(String pMenuId);
   //下级菜单列表、
   ResultVO<List<Map<String,Object>>> getMenuLevelList(SystemRoleMenu roleMenu);
   //检查菜单名称是否重复
   ResultVO<Boolean> checkMenuName(SystemMenu menu);
 
}
