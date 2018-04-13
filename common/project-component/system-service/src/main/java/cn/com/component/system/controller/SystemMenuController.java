package cn.com.component.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.util.ConvertUtil;
import cn.com.component.controller.BaseController;
import cn.com.component.service.cm.bean.SystemMenu;
import cn.com.component.service.cm.bean.SystemRoleMenu;
import cn.com.component.system.cm.service.SystemMenuService;

/**
 * 系统菜单控制层
 *
 */
@Controller
@RequestMapping("/sysMenu")
public class SystemMenuController extends BaseController {
	@Autowired
    private SystemMenuService menuService;
	/**
	 * 菜单增加修改页面
	 * @param menuId
	 * @param map
	 * @return
	 */
    @RequestMapping("/menuAdd")
    public String menuAdd(@RequestParam(required=false) String menuId,ModelMap map){
    	 SystemMenu menu = new SystemMenu();
    	 if(!StringUtils.isEmpty(menuId)){
    		 ResultVO<SystemMenu> rdo = menuService.getMenu(menuId);
    		 if(rdo.isOk()){
    			 menu = rdo.getObj();
    		 }
    	 }
    	 map.put("dataInfo", menu);
    	 return "/system/menu/menuAdd";
    }
    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    @RequestMapping("/menuDel")
    public @ResponseBody ResultVO<?> delMenu(@RequestParam String menuId){
    	return menuService.deleteMenu(menuId);
    }
    /**
     * 菜单列表
     * @param menuId
     * @param map
     * @return
     */
    @RequestMapping("/menuAuthList")
    public String menuList(String menuId,ModelMap map){
    	if(StringUtils.isEmpty(menuId)){
    		menuId = "0";//查找全部父级菜单，然后递归查询子菜单
    	}
    	SystemRoleMenu roleMenu = new SystemRoleMenu();
    	roleMenu.setMenuId(menuId);
    	ResultVO<List<Map<String,Object>>> res = menuService.getMenuLevelList(roleMenu);
        if(res.isOk()){
        	map.put("menuData", ConvertUtil.toJsonString(res.getObj()));
        }
    	return "/system/menu/menuAuthList";
    }
    //检查菜单名称是否重复
   @RequestMapping("/checkMenuName")
   public @ResponseBody ResultVO<?> checkMenuname(SystemMenu menu){
	   return menuService.checkMenuName(menu);
   }
   /**
    * 增加修改菜单方法
    * @param menu
    * @return
    */
   @RequestMapping("/menuAddMethod")
   public @ResponseBody ResultVO<?> addMethod(SystemMenu menu){
	   ResultVO<?> res = null;
	   if(StringUtils.isEmpty(menu.getMenuId())){
		   menu.setCreateLoginName(getCurrentLoginName());
		   res = menuService.addMenu(menu);
	   }else{
		   res = menuService.updateMenu(menu);
	   }
	   return res;
   }
   /**
    * 选择菜单
    * @param menuId
    * @return
    */
   @RequestMapping("/choiceMenu")
   public @ResponseBody ResultVO<?> menuListData(String menuId){
	    if(StringUtils.isEmpty(menuId)){
   		  menuId = "0";//查找全部父级菜单， 后递归查询子菜单
   	    }
	    SystemRoleMenu roleMenu = new SystemRoleMenu();
    	roleMenu.setMenuId(menuId);
      	ResultVO<List<Map<String,Object>>> res = menuService.getMenuLevelList(roleMenu);
      	return res;
   }
 }
