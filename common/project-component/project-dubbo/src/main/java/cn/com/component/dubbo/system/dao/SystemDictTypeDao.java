package cn.com.component.dubbo.system.dao;

import java.util.List;

import cn.com.component.service.cm.bean.SystemDictType;



public interface SystemDictTypeDao {
    /**删除**/
    int deleteByPrimaryKey(Long id);
    /**增加（非空判断）**/
    int insertSelective(SystemDictType record);

    /**查询**/
    SystemDictType selectByPrimaryKey(Long id);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(SystemDictType record);
    /**字典类型列表**/
    List<SystemDictType> getSystemDictTypeList();
    
    SystemDictType selectBySearch(SystemDictType record);
}