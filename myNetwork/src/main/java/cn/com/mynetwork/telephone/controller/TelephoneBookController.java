package cn.com.mynetwork.telephone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.component.controller.BaseController;
import cn.com.mynetwork.bean.TelephoneBook;
import cn.com.mynetwork.service.TelephoneBookService;
@Controller
@RequestMapping("/telePhoneBook")
public class TelephoneBookController extends BaseController {
	@Autowired
    private TelephoneBookService bookService;

	/*
	 * 列表页面
	 */
	@RequestMapping("/bookList")
	public String list(){
		return "telephoneBook/bookList";
	}
	/**
	 * 列表数据
	 * @param pager
	 * @param param
	 * @return
	 */
	@RequestMapping("/bookListData")
	public @ResponseBody ResultVO<Page<TelephoneBook>> getBookData(Page<TelephoneBook> pager,TelephoneBook param){
		if(!getCurrentUser().isContain("1")){
			param.setCreateId(getCurrentUserId());//非管理员角色只查看自己的通讯录
		}
		ResultVO<Page<TelephoneBook>> res = bookService.getPhoneBookList(new PageVO<TelephoneBook>(pager, param));
		return res;
	}
	/**
	 * 增加页面
	 * @param bookId
	 * @param map
	 * @return
	 */
	@RequestMapping("/addOrUpdateBook")
	public String addBook(String bookId,ModelMap map){
		 TelephoneBook dataInfo = new TelephoneBook();
		 if(!StringUtils.isEmpty(bookId)){
			 ResultVO<TelephoneBook> res = bookService.getBookInfo(bookId);
			 if(res.isOk()){
				 dataInfo = res.getObj();
			 }
		 }
		 map.put("dataInfo", dataInfo);
		 return "telephoneBook/addOrUpdateBook";
	}
	/**
	 * 增加方法
	 * @param book
	 * @return
	 */
	@RequestMapping("/addBookMethod")
	public @ResponseBody ResultVO<?> addMethod(TelephoneBook book){
		ResultVO<Boolean> res = null;
		if(StringUtils.isEmpty(book.getId())){
			book.setCreateId(getCurrentUserId());
			res = bookService.addBook(book);
		}else{
			res = bookService.updateBook(book);
		}
		return res;	
	}
	/**
	 * 删除通讯录
	 * @param bookId
	 * @return
	 */
	@RequestMapping("/delBook")
	public @ResponseBody ResultVO<?> delBook(String bookId){
		return bookService.delBook(bookId);
	}
	/**
	 * 通讯录详情
	 * @param bookId
	 * @param map
	 * @return
	 */
	@RequestMapping("/bookInfo")
	public String getBookInfo(String bookId,ModelMap map){
		ResultVO<TelephoneBook> res = bookService.getBookInfo(bookId);
		if(res.isOk()){
			map.put("dataInfo", res.getObj());
		}
		return "telephoneBook/bookInfo";
	}
}
