package cn.com.component.system.ehcache;

import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.com.component.service.cm.bean.SystemDict;
import cn.com.component.spring.context.SpringContextHolder;
import cn.com.component.system.cm.ehcache.ICacheService;
import cn.com.component.system.cm.service.CommonCacheService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
@SuppressWarnings("unchecked")
public class EacheService implements ICacheService {
	private CacheManager cacheManager;
	private static Map<String, List<String>> map = Maps.newConcurrentMap();

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public static EacheService getInstance() {
		return (EacheService) SpringContextHolder.getBean("eacheService");
	}

	// 获得缓存对象，不存在直接创建
	private Cache getCache(String cacheName) {
		Cache cache = this.cacheManager.getCache(cacheName);
		if (StringUtils.isEmpty(cache)) {
			synchronized (this) {
				if (StringUtils.isEmpty(this.cacheManager.getCache(cacheName))) {
					this.cacheManager.addCache(cacheName);
					cache = cacheManager.getCache(cacheName);
					cache.getCacheConfiguration().setEternal(true);// 永恒
				}
			}
		}
		return cache;
	}

	/**
	 * 获取指定的缓存内容
	 */
	@Override
	public Object getCache(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		Element element = cache.get(key);
		return StringUtils.isEmpty(element) ? null : element.getObjectValue();
	}

	/**
	 * 增加缓存
	 */
	@Override
	public void put(String cachename, String key, Object object) {
		Element element = new Element(key, object);
		List<String> list = map.get(cachename);
		if (StringUtils.isEmpty(list)) {
			list = Lists.newArrayList();
		} 
		list.add(key);
		map.put(cachename, list);
		// 增加缓存
		getCache(cachename).put(element);
	}

	/**
	 * 移除缓存
	 */
	@Override
	public void removeByCacheName(String cacheName) {
		List<String> list = map.get(cacheName);
		Cache cache = getCache(cacheName);
		if (!StringUtils.isEmpty(list)) {
			for (String string : list) {
				cache.remove(string);
			}
		}
	}

	@Override
	public void remove(String cacheName, String key) {
		getCache(cacheName).remove(key);

	}
	
	@Override
	public List<SystemDict> getSystemDictList() {
		String key = DICT_CACHE + "_dict_list";
		
		List<SystemDict> dictList = (List<SystemDict>) getCache(DICT_CACHE, key);
		if (StringUtils.isEmpty(dictList)) {
			dictList = Lists.newArrayList();
			CommonCacheService service = getComCacheService();
			if (service != null) {
				dictList = service.getSystemDictList();
				put(DICT_CACHE, key, dictList);
			}

		}
		return dictList;
	}

	protected CommonCacheService getComCacheService() {
		return (CommonCacheService) SpringContextHolder.getBean("commonCacheService");
	}
   //获取指定类型的数据字典
	@Override
	public List<SystemDict> getSystemDictList(String code) {
	    String key = DICT_CACHE + "_dict_list_" + code;
		List<SystemDict> dictList = (List<SystemDict>) getCache(DICT_CACHE, key);
		if (StringUtils.isEmpty(dictList)) {
			dictList = Lists.newArrayList();
			CommonCacheService service = getComCacheService();
			if (service != null) {
				List<SystemDict> dictAllList = service.getSystemDictList();
				for(SystemDict dict : dictAllList){
					if(code.equals(dict.getCode())){
						dictList.add(dict);
					}
				}
				put(DICT_CACHE, key, dictList);
			}

		}
		return dictList;
	}
   //获取字典值对应的字典名称
	@Override
	public String getDictLabel(String code, String codeValue) {
		List<SystemDict> dictList = getSystemDictList(code);
		String label = "";
		for(SystemDict dict : dictList){
			if(dict.getCode().equals(code)&&dict.getCodeValue().equals(codeValue)){
				 label = dict.getCodeLabel();
				 break;
			}
		}
		return label;
	}
}
