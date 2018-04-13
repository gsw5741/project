package cn.com.component.dubbo.system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.component.dubbo.system.dao.SysLoginLogDao;
import cn.com.component.service.cm.bean.SysLoginLog;
import cn.com.component.system.cm.service.SysLoginLogService;

public class SysLoginLogServiceImpl implements SysLoginLogService {
	@Autowired
    private SysLoginLogDao logDao;
	/**
	 * 增加登录日志
	 */
	@Override
	public ResultVO<SysLoginLog> addLoginLog(SysLoginLog record) {
		try {
			record.setLoginId(UUID.randomUUID().toString());
			logDao.insertSelective(record);
		} catch (Exception e) {
			BaseLogger.error(e);
			return new ResultVO<SysLoginLog>(ResMsg.ADD_EXCEPTION.getErrorCode(),ResMsg.ADD_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<SysLoginLog>(record);
	}
    /**
     * 列表查询
     */
	@Override
	public ResultVO<Page<SysLoginLog>> getLoginLogList(PageVO<SysLoginLog> pageVo) {
		Page<SysLoginLog> pager = pageVo.getPage();
		try {
			int total = logDao.getTotal(pageVo.getParam());
			pager.setTotal(total);
			List<SysLoginLog> list = logDao.listPageSysLoginLog(pageVo);
			pager.setDataList(list);
		} catch (Exception e) {
			BaseLogger.error(e);
			return new ResultVO<Page<SysLoginLog>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Page<SysLoginLog>>(pager);
	}

}
