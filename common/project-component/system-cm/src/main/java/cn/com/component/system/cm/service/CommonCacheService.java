package cn.com.component.system.cm.service;

import java.util.List;

import cn.com.component.service.cm.bean.SystemDict;


public interface CommonCacheService {
	 //获取全部数据字典
	  List<SystemDict> getSystemDictList();
}
