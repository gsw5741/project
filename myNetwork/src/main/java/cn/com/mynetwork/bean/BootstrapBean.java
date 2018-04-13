package cn.com.mynetwork.bean;

import java.io.Serializable;

public class BootstrapBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String searchText;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
  
}
