package cn.com.component.dubbo.system.dao;

import java.util.List;

import cn.cn.com.common.vo.PageVO;
import cn.com.component.service.cm.bean.SystemDict;


public interface SystemDictDao {
    /**删除**/
    int deleteByPrimaryKey(Long id);

    /**增加（非空判断）**/
    int insertSelective(SystemDict record);

    /**查询**/
    SystemDict selectByPrimaryKey(Long id);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(SystemDict record);
  
    //所有的字典
    List<SystemDict> getSystemDictList();
    //字典分页
    List<SystemDict> listPageSystemDictList(PageVO<SystemDict> pageVo);
    //获得总数
    int getTotal(SystemDict param);
    //删除
    void deleteByCode(String code);
}