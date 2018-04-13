package cn.com.component.system.cm.service;

import java.util.List;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.component.service.cm.bean.SystemDict;
import cn.com.component.service.cm.bean.SystemDictType;

public interface SystemDictService {
   //增加数据字典
   ResultVO<Boolean> addDict(SystemDict record);
   //更新数据字典
   ResultVO<Boolean> updateDict(SystemDict record);
  
   //数据字典列表
   ResultVO<Page<SystemDict>> getSystemDictList(PageVO<SystemDict> pageVo); 
   //数据字典详情
   ResultVO<SystemDict> getDictInfo(Long id);
   //删除数据字典
   ResultVO<Boolean> deleteDict(Long id);
   //字典类型列表
   ResultVO<List<SystemDictType>> getDictTypeList(); 
   //字典类型详情
   ResultVO<SystemDictType> getDictType(Long id);
   
   //增加字典类型
   ResultVO<Boolean> addDictType(SystemDictType record);
   //更新字典类型
   ResultVO<Boolean> updateDictType(SystemDictType record);
   //检查字典代码是否重复
   ResultVO<Boolean> checkDictCode(SystemDictType search);
}
