package cn.com.component.dubbo.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.component.dubbo.service.BaseService;
import cn.com.component.dubbo.system.dao.SystemDictDao;
import cn.com.component.dubbo.system.dao.SystemDictTypeDao;
import cn.com.component.service.cm.bean.SystemDict;
import cn.com.component.service.cm.bean.SystemDictType;
import cn.com.component.system.cm.service.SystemDictService;

public class SystemDictServiceImpl extends BaseService implements SystemDictService {
    @Autowired
	private SystemDictDao dictDao;
    @Autowired
    private SystemDictTypeDao dictTypeDao;
    //增加数据字典
	@Override
	public ResultVO<Boolean> addDict(SystemDict record) {
		try {
			dictDao.insertSelective(record);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.ADD_EXCEPTION.getErrorCode(),ResMsg.ADD_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
    //更新数据字典
	@Override
	public ResultVO<Boolean> updateDict(SystemDict record) {
		try {
			dictDao.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.UPDATE_EXCEPTION.getErrorCode(),ResMsg.UPDATE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
   
   //字典分页
	@Override
	public ResultVO<Page<SystemDict>> getSystemDictList(PageVO<SystemDict> pageVo) {
		Page<SystemDict> pager = pageVo.getPage();
		try {
			int total = dictDao.getTotal(pageVo.getParam());
			List<SystemDict> list = dictDao.listPageSystemDictList(pageVo);
		    pager.setDataList(list);
		    pager.setTotal(total);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Page<SystemDict>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Page<SystemDict>>(pager);
	}
	//字典详情
	@Override
	public ResultVO<SystemDict> getDictInfo(Long id) {
		SystemDict dict = dictDao.selectByPrimaryKey(id);
		if(dict == null){
			return new ResultVO<SystemDict>(ResMsg.COM_EXCEPTION.getErrorCode(),"数据不存在");
		}
		return new ResultVO<SystemDict>(dict);
	}
	//删除数据字典
	@Override
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRES_NEW,rollbackFor = {Exception.class})
	public ResultVO<Boolean> deleteDict(Long id) {
		try {
			SystemDictType type = dictTypeDao.selectByPrimaryKey(id);
			dictDao.deleteByCode(type.getCode());
			dictTypeDao.deleteByPrimaryKey(id);
			
		} catch (Exception e) {
			rollback();
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.DELETE_EXCEPTION.getErrorCode(),ResMsg.DELETE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
	//字典类型列表
	@Override
	public ResultVO<List<SystemDictType>> getDictTypeList() {
		List<SystemDictType> list = new ArrayList<SystemDictType>();
		try {
			list = dictTypeDao.getSystemDictTypeList();
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<List<SystemDictType>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<List<SystemDictType>>(list);
	}
	@Override
	public ResultVO<SystemDictType> getDictType(Long id) {
		SystemDictType type = dictTypeDao.selectByPrimaryKey(id);
		if(type == null){
			return new ResultVO<SystemDictType>(ResMsg.COM_EXCEPTION.getErrorCode(),"数据不存在");
		}
		return new ResultVO<SystemDictType>(type);
	}
	@Override
	public ResultVO<Boolean> addDictType(SystemDictType record) {
		try {
			dictTypeDao.insertSelective(record);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.ADD_EXCEPTION.getErrorCode(),ResMsg.ADD_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
	@Override
	public ResultVO<Boolean> updateDictType(SystemDictType record) {
		try {
			dictTypeDao.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			BaseLogger.error(e.getMessage());
			return new ResultVO<Boolean>(ResMsg.UPDATE_EXCEPTION.getErrorCode(),ResMsg.UPDATE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
	@Override
	public ResultVO<Boolean> checkDictCode(SystemDictType search) {
		ResultVO<Boolean> res = new ResultVO<Boolean>(true);
		SystemDictType dictType = dictTypeDao.selectBySearch(search);
		if(dictType!=null){
			res.setOk(false);
		}
		return res;
	}
   
}
