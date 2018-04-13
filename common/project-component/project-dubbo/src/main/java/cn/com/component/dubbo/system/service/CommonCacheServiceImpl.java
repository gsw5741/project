package cn.com.component.dubbo.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.component.dubbo.system.dao.SystemDictDao;
import cn.com.component.service.cm.bean.SystemDict;
import cn.com.component.system.cm.service.CommonCacheService;

public class CommonCacheServiceImpl implements CommonCacheService {
    @Autowired
	private SystemDictDao dictDao;
	@Override
	public List<SystemDict> getSystemDictList() {
		return dictDao.getSystemDictList();
	}

}
