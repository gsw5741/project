package cn.com.component.system.cm.service;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.component.service.cm.bean.SysLoginLog;

public interface SysLoginLogService {
	/**增加系统登录日志
	 * @param record
	 * @return
	 */
    ResultVO<SysLoginLog> addLoginLog(SysLoginLog record);
    /**
     * 系统登录日志列表查询
     * @param pageVo
     * @return
     */
    ResultVO<Page<SysLoginLog>> getLoginLogList(PageVO<SysLoginLog> pageVo);
}
