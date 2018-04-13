package cn.com.mynetwork.dao;

import cn.com.mynetwork.bean.TelephoneBookGroup;

public interface TelephoneBookGroupMapper {
    /**删除**/
    int deleteByPrimaryKey(String id);

    int insert(TelephoneBookGroup record);

    /**增加（非空判断）**/
    int insertSelective(TelephoneBookGroup record);

    /**查询**/
    TelephoneBookGroup selectByPrimaryKey(String id);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(TelephoneBookGroup record);

    int updateByPrimaryKey(TelephoneBookGroup record);
}