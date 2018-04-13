package cn.cn.com.common.vo;

import java.io.Serializable;

import cn.com.common.util.ConvertUtil;

public class BaseVO implements Serializable{
 
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Override
	public String toString(){
		  return ConvertUtil.toJsonString(this);
	  }

}
