package cn.com.mynetwork.dao;

import java.util.List;

import cn.cn.com.common.vo.PageVO;
import cn.com.mynetwork.bean.TelephoneBook;

public interface TelephoneBookDao {
    /**删除**/
    int deleteByPrimaryKey(String id);

    /**增加（非空判断）**/
    int insertSelective(TelephoneBook record);

    /**查询**/
    TelephoneBook selectByPrimaryKey(String id);

    /**更新（非空判断）**/
    int updateByPrimaryKeySelective(TelephoneBook record);
    /**
     * 通讯录列表
     * @param pageVO
     * @return
     */
    List<TelephoneBook> listPageTelephoneBookList(PageVO<TelephoneBook> pageVO);
    //获得总数
    int getTotal(TelephoneBook param);

}