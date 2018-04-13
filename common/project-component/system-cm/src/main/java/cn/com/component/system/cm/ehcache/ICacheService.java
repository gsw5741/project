package cn.com.component.system.cm.ehcache;

import java.util.List;

import cn.com.component.service.cm.bean.SystemDict;


/**
 * 业务缓存接口
 *
 */
public interface ICacheService {
   static final  String SYS_CACHE = "SYS_CACHE";
   static final String DICT_CACHE = "DICT_CACHE";
   //获得缓存对象
   Object getCache(String cacheName,String key);
   //放入缓存中
   void put(String cachename,String key,Object object);
   //移除指定的缓存
   void removeByCacheName(String cacheName);
   //移除缓存
   void remove(String cacheName,String key);
   //获取全部数据字典
   List<SystemDict> getSystemDictList();
   //获取指定类型的数据字典
   List<SystemDict> getSystemDictList(String code);
   //获取指定类型的数据字典名称
   String getDictLabel(String code,String codeValue);
   
}