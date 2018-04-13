package cn.com.component.system.redis.service;

import cn.cn.com.common.vo.ResultVO;
import cn.com.component.system.redis.cache.RedisCache;

public interface RedisCacheService<T> {
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
    ResultVO<RedisCache<T>> getRedisCache(String key);
    /**
     * 增加缓存
     * @param record
     * @return
     */
    ResultVO<Boolean> addRedisCache(RedisCache<T> record);
    /**
     * 删除缓存
     * @param key
     * @return
     */
    ResultVO<Boolean> deleteRedisCache(String key);
}
