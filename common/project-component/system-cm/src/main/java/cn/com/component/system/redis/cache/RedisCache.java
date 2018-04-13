package cn.com.component.system.redis.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存
 *
 * @param <T>
 */
public class RedisCache<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 缓存键
	 */
	private String key;
	/**
	 * 缓存字符串
	 */
	private String value;

	/**
	 * hash缓存
	 */
	private Map<String, T> hashCache;

	/**
	 * list缓存
	 */
	private List<T> listCache;

	/**
	 * set缓存
	 */
	private Set<T> setCache;
    /**
     * 超时
     */
	private Long timeOut;

	/**
	 * 超时间单位
	 */
	private TimeUnit timeUnit;
	public RedisCache(){
		
	}
	public RedisCache(String key,String value){
		this.key = key;
		this.value = value;
	}
	public RedisCache(String key,String value,Long timeOut,TimeUnit unit){
		this.key = key;
		this.value = value;
		this.timeOut = timeOut;
		this.timeUnit = unit;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, T> getHashCache() {
		return hashCache;
	}

	public void setHashCache(Map<String, T> hashCache) {
		this.hashCache = hashCache;
	}

	public List<T> getListCache() {
		return listCache;
	}

	public void setListCache(List<T> listCache) {
		this.listCache = listCache;
	}

	public Set<T> getSetCache() {
		return setCache;
	}

	public void setSetCache(Set<T> setCache) {
		this.setCache = setCache;
	}

	public Long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Long timeOut) {
		this.timeOut = timeOut;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}
    
}
