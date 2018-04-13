package cn.com.mynetwork.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.mynetwork.bean.TelephoneBook;
import cn.com.mynetwork.dao.TelephoneBookDao;
import cn.com.mynetwork.service.TelephoneBookService;
@Service("telephoneBookService")
public class TelephoneBookServiceImpl extends BaseService implements TelephoneBookService {
	@Autowired
    private TelephoneBookDao bookDao;
	/**
	 * 通讯录列表
	 */
	@Override
	public ResultVO<Page<TelephoneBook>> getPhoneBookList(PageVO<TelephoneBook> pageVO) {
		Page<TelephoneBook> pager = pageVO.getPage();
		try {
			List<TelephoneBook> list = bookDao.listPageTelephoneBookList(pageVO);
			int total = bookDao.getTotal(pageVO.getParam());
			pager.setDataList(list);
			pager.setTotal(total);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Page<TelephoneBook>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Page<TelephoneBook>>(pager);
	}
	/**
	 * 通讯录详情
	 */
	@Override
	public ResultVO<TelephoneBook> getBookInfo(String bookId) {
		TelephoneBook book = bookDao.selectByPrimaryKey(bookId);
		return new ResultVO<TelephoneBook>(book);
	}
	/**
	 * 增加通讯录
	 */
	@Override
	public ResultVO<Boolean> addBook(TelephoneBook record) {
		try {
			record.setId(UUID.randomUUID().toString());
			bookDao.insertSelective(record);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.ADD_EXCEPTION.getErrorCode(),ResMsg.ADD_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
	/**
	 * 更新通讯录
	 */
	@Override
	public ResultVO<Boolean> updateBook(TelephoneBook record) {
		try {
			bookDao.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.UPDATE_EXCEPTION.getErrorCode(),ResMsg.UPDATE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
	/**
	 * 删除通讯录
	 */
	@Override
	public ResultVO<Boolean> delBook(String bookId) {
		try {
			bookDao.deleteByPrimaryKey(bookId);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.DELETE_EXCEPTION.getErrorCode(),ResMsg.DELETE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}

}
