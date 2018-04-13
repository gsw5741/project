package cn.com.component.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cn.com.common.vo.ResultVO;
import cn.com.component.controller.BaseController;
import cn.com.component.service.cm.bean.SystemRoleMenu;
import cn.com.component.system.cm.service.SystemMenuService;
import cn.com.component.system.cm.service.SystemRoleService;
import cn.com.component.user.cm.bean.SystemRole;


@Controller
@RequestMapping("/sysRole")
public class SystemRoleController extends BaseController {
	@Autowired
    private SystemRoleService roleService;
	@Autowired
	private SystemMenuService menuService;
	//角色列表
	@RequestMapping("/roleList")
	public String roleList(ModelMap map){
		ResultVO<List<SystemRole>> res = roleService.getRoleList();
		if(res.isOk()){
			List<SystemRole> list = res.getObj();
		    map.put("roleList", list);  
		}
		return "system/role/roleList";
	}
	//角色菜单
	@RequestMapping(value = "/roleMenuData")
	public @ResponseBody ResultVO<?> roleMenuList(SystemRoleMenu roleMenu){
		ResultVO<List<Map<String,Object>>> res = menuService.getMenuLevelList(roleMenu);//全部菜单
		return res;
	}
	/**
	 * 增加角色菜单
	 * @param menuIds
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/addRoleMenu")
	public @ResponseBody ResultVO<?> addRoleMenu(String[] menuIds,String roleId){
		List<SystemRoleMenu> list = new ArrayList<SystemRoleMenu>();
		if(!StringUtils.isEmpty(menuIds)){
			for(String s : menuIds){
				SystemRoleMenu roleMenu = new SystemRoleMenu();
				roleMenu.setMenuId(s);
				roleMenu.setRoleId(roleId);
				list.add(roleMenu);
			}
		}
		return roleService.addRoleMenuList(list);
	}
	//角色增加页面
	@RequestMapping("/roleAdd")
	public String roleAdd(String roleId,ModelMap map){
		SystemRole role = new SystemRole();
		if(!StringUtils.isEmpty(roleId)){
			ResultVO<SystemRole> res = roleService.getRole(roleId);
			if(res.isOk()){
				role = res.getObj();
			}
		}
		map.put("dataInfo", role);
		return "system/role/roleAdd";
	}
	/**
	 * 角色详情
	 * @param roleId
	 * @param map
	 * @return
	 */
	@RequestMapping("/roleInfo")
	public String roleInfo(String roleId,ModelMap map){
		ResultVO<SystemRole> res = roleService.getRole(roleId);
		if(res.isOk()){
			map.put("dataInfo", res.getObj());
		}
		return "system/role/roleInfo";
	}
	/**
	 * 角色增加方法
	 * @param role
	 * @return
	 */
	@RequestMapping("/roleAddMethod")
	public @ResponseBody ResultVO<?> addMethod(SystemRole role){
		ResultVO<Boolean> res = null;
		if(StringUtils.isEmpty(role.getRoleId())){
			role.setCreateLoginName(getCurrentLoginName());
			res = roleService.addRole(role);
		}else{
			res = roleService.updateRole(role);
		}
		return res;
	}
	/**
	 * 检查角色名是否重复
	 * @param role
	 * @return
	 */
	@RequestMapping("/checkRoleName")
	public @ResponseBody ResultVO<?> checkRoleName(SystemRole role){
		return roleService.checkRoleName(role);
	}
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/delRole")
	public @ResponseBody ResultVO<?> delRole(String roleId){
		return roleService.deleteRole(roleId);
	}
}
