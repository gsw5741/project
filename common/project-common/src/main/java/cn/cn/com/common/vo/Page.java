package cn.cn.com.common.vo;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	/** 每页显示 */
	private int pageSize = 10;
	/** 当前页 */
	private int pageNumber = 1;
	/** 总数 */
	private int total;
	/**页数*/
	private int pages;
	/**存放结果集*/
	private List<T> dataList=new ArrayList<T>();
	private String sortName;
	private String sortOrder;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getPages() {
		if(total>0){
			if(total%pageSize==0){
				pages=total/pageSize;
			}else{
				pages=total/pageSize+1;
			}
		}else{
			pages=1;
		}
		
		
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
}
