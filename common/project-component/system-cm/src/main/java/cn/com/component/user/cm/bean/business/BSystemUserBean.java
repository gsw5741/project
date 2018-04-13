package cn.com.component.user.cm.bean.business;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import cn.com.common.util.StringUtil;
import cn.com.component.service.cm.bean.SystemMenu;
import cn.com.component.user.cm.bean.SystemRole;
/**
 * 系统用户
 *
 */
public class BSystemUserBean extends BaseSysUserBean {
	private static final long serialVersionUID = 1L;
	//角色列表
    private List<BSystemRoleBean> roleList=Lists.newArrayList();
	//角色列表不包含菜单
    private List<SystemRole> tRoleList= Lists.newArrayList();
    //菜单列表
    private List<SystemMenu> menuList=Lists.newArrayList();
	//角色IDs
	private List<String> roleListIds=Lists.newArrayList();
	//菜单权限
	private Set<String> menuAuthSet = Sets.newLinkedHashSet();
	/** 
	 * 角色列表
	 */
    @Override
	public List<BSystemRoleBean> getRoleList() {
		return roleList;
	}
    /**
     * 菜单列表
     */
	@Override
	public List<SystemMenu> getMenuList() {
		if(!roleList.isEmpty()){
			for(BSystemRoleBean role : roleList){
				if(role.getMenuList().size()>0){
					for(SystemMenu menu : role.getMenuList()){
						if(StringUtil.isNotEmpty(menu.getMenuAuth())){
							menuAuthSet.add(menu.getMenuAuth());
						}
						menuList.add(menu);
					}
				}
			}
		}
		if(menuList.size()>0){
			//对菜单进行去除重复
			menuList = StringUtil.removeExistsElement(menuList);
			//对菜单进行排序
			Collections.sort(menuList, new Comparator<SystemMenu>() {
				@Override
				public int compare(SystemMenu o1, SystemMenu o2) {
					//处于同一菜单下，比较子菜单
					if(o1.getpMenuId().equals(o2.getpMenuId())){
						return o1.getSort() - o2.getSort();
					}
//					if(o1.getMenuId().equals(o2.getpMenuId())){
//						o1.setLeaf((byte)1);//存在子节点
//						o2.setLeaf((byte)0);//b
//					}
					return 0;
				}
			
			});
		}
		return menuList;
	}
    /**
     * 角色ID
     */
	@Override
	public List<String> getRoleListIds() {
		if(!roleList.isEmpty()){
			for(BSystemRoleBean bean:roleList){
				roleListIds.add(bean.getRoleId());
			}
		}
		
		return roleListIds;
	}
    /**
     * 是否包含指定角色
     */
	@Override
	public boolean isContain(String roleId) {
		return roleListIds.contains(roleId);
	}

	public void setRoleList(List<BSystemRoleBean> roleList) {
		this.roleList = roleList;
	}

	public void setMenuList(List<SystemMenu> menuList) {
		this.menuList = menuList;
	}

	public void setRoleListIds(List<String> roleListIds) {
		this.roleListIds = roleListIds;
	}

	public List<SystemRole> gettRoleList() {
		return tRoleList;
	}

	public void settRoleList(List<SystemRole> tRoleList) {
		this.tRoleList = tRoleList;
	}

	@Override
	public Set<String> getMenuAuthSet() {
		return menuAuthSet;
	}
    
}
