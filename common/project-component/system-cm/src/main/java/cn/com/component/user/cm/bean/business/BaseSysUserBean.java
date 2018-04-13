package cn.com.component.user.cm.bean.business;

import java.util.List;
import java.util.Set;

import cn.com.component.user.cm.bean.SystemUser;

/**
 * 定义系统用户，包含用户的角色，菜单权限等
 *
 */
public abstract class BaseSysUserBean extends SystemUser {
	private static final long serialVersionUID = 1L;
    /**
     *  角色列表
     */

   protected abstract List<?> getRoleList();
    /**
     * 菜单列表
     */

   protected abstract List<?> getMenuList();
    /**
     *  角色ID
     */

   protected abstract List<String> getRoleListIds();

    /**
     * 判断是否包含某个角色
     * @param roleId
     * @return
     */
   protected abstract boolean isContain(String roleId);
   /**
    * 获取菜单权限
    * @return
    */
   protected abstract Set<String> getMenuAuthSet();

}
