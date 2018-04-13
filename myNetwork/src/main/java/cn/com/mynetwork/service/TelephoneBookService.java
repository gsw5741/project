package cn.com.mynetwork.service;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.mynetwork.bean.TelephoneBook;

public interface TelephoneBookService {
	//通讯录列表
   ResultVO<Page<TelephoneBook>> getPhoneBookList(PageVO<TelephoneBook> pageVO);
   //通讯录详情
   ResultVO<TelephoneBook> getBookInfo(String bookId);
   //增加通讯录
   ResultVO<Boolean> addBook(TelephoneBook record);
   //更新通讯录
   ResultVO<Boolean> updateBook(TelephoneBook record);
   //删除通讯录
   ResultVO<Boolean> delBook(String bookId);
   
   
}
