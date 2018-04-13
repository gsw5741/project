package cn.com.component.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.component.controller.BaseController;
import cn.com.component.service.cm.bean.SystemDict;
import cn.com.component.service.cm.bean.SystemDictType;
import cn.com.component.system.cm.service.SystemDictService;

@Controller
@RequestMapping("/sysDict")
public class SystemDictController extends BaseController {
  @Autowired
  private SystemDictService dictService;
  /**
   * 字典类型列表
   * @param map
   * @return
   */
  @RequestMapping("/dictTypeList")
  public String dictList(ModelMap map){
	  List<SystemDictType> list = dictService.getDictTypeList().getObj();
	  map.put("dictListType", list);
	  return "system/dict/dictTypeList";
  }
  /***
   * 字典列表
   * @param code
   * @param map
   * @return
   */
  @RequestMapping("/dictList")
  public String dictList(SystemDict search,ModelMap map){
	  map.put("searchBean", search);
	  return "system/dict/dictList";
  }
  /**
   * 字典数据
   * @param pager
   * @param param
   * @return
   */
  @RequestMapping("/dictData")
  public @ResponseBody ResultVO<?> dictData(Page<SystemDict> pager,SystemDict param){
	  ResultVO<Page<SystemDict>> res = dictService.getSystemDictList(new PageVO<SystemDict>(pager, param));
	  return res;
  }
  /**
   * 增加字典页面
   * @param id
   * @param map
   * @return
   */
  @RequestMapping("/addDict")
  public String addDict(Long dictId,SystemDictType type,ModelMap map){
	  SystemDict dict = new SystemDict();
	  dict.setDictTypeId(type.getTypeId());
	  dict.setCode(type.getCode());
	  if(!StringUtils.isEmpty(dictId)){
		  ResultVO<SystemDict> res = dictService.getDictInfo(dictId);
		  if(res.isOk()){
			  dict = res.getObj();
		  }
	  }
	  map.put("dataInfo", dict);
	  return "system/dict/addOrUpdateDict";
  }
  @RequestMapping("/addDictMethod")
  public @ResponseBody ResultVO<?> addDict(SystemDict dict,String flag){
	  ResultVO<Boolean> res = null;
	  if(StringUtils.isEmpty(dict.getDictId())){
		  dict.setCreateId(getCurrentUserId());
		  dict.setCreateLoginName(getCurrentLoginName());
		  res = dictService.addDict(dict);
	  }else{
		  if("Y".equals(flag)){
			  dict.setDelFlag((byte)1);//启用
		  }
		  if("N".equals(flag)){
			  dict.setDelFlag((byte)2);//禁用
		  }
		  res = dictService.updateDict(dict);
	  }
	 return res;	  
  }
 
  @RequestMapping("/delDict")
  public @ResponseBody ResultVO<?> delete(Long typeId){
	  return dictService.deleteDict(typeId);
  }
  @RequestMapping("/addDictType")
  public String addDictType(Long typeId,ModelMap map){
	  SystemDictType dataInfo = new SystemDictType();
	  if(!StringUtils.isEmpty(typeId)){
		  ResultVO<SystemDictType> res = dictService.getDictType(typeId);
		  if(res.isOk()){
			  dataInfo = res.getObj();
		  }
	  }
	  map.put("dataInfo", dataInfo);
	  return "system/dict/addDictType";
  }
  @RequestMapping("/addTypeMethod")
  public @ResponseBody ResultVO<?> addMethod(SystemDictType type){
	   ResultVO<Boolean> res = null;
	   if(StringUtils.isEmpty(type.getTypeId())){
		   res = dictService.addDictType(type);
	   }else{
		   res = dictService.updateDictType(type);
	   }
	   return res;
  }
  @RequestMapping("/checkDictCode")
  public @ResponseBody ResultVO<?> checkCode(SystemDictType search){
	  return dictService.checkDictCode(search);
  }
  

} 
