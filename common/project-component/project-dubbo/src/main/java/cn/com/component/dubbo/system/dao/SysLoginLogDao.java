package cn.com.component.dubbo.system.dao;

import java.util.List;

import cn.cn.com.common.vo.PageVO;
import cn.com.component.service.cm.bean.SysLoginLog;

public interface SysLoginLogDao {

    /**增加（非空判断）**/
    int insertSelective(SysLoginLog record);
    /**
     * 列表查询
     * @param pageVo
     * @return
     */
    List<SysLoginLog> listPageSysLoginLog(PageVO<SysLoginLog> pageVo);
    /**
     * 获得总数
     * @param param
     * @return
     */
    int getTotal(SysLoginLog param);
    
}