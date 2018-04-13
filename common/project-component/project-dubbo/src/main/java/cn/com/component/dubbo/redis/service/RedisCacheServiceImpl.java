package cn.com.component.dubbo.redis.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.connection.DataType;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.message.ResMsg;
import cn.com.common.util.StringUtil;
import cn.com.component.spring.data.redis.manager.RedisManager;
import cn.com.component.system.redis.cache.RedisCache;
import cn.com.component.system.redis.service.RedisCacheService;

public class RedisCacheServiceImpl<T> implements RedisCacheService<T> {
	private RedisManager redisManager;

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	/**
	 * 获取缓存
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ResultVO<RedisCache<T>> getRedisCache(String key) {
		RedisCache<T> redisCache = new RedisCache<T>();
		try {
			DataType type = redisManager.getDataType(key);
			switch (type) {
			case STRING:
				Object value = redisManager.get(key);
				if (StringUtil.isNotEmpty(value)) {
					redisCache.setValue(String.valueOf(value));
				}
				break;
			case LIST:
				List<T> list = (List<T>) redisManager.getList(key);
				if (StringUtil.isNotEmptyList(list)) {
					redisCache.setListCache(list);
				}
				break;
			case HASH:
				Map<String, T> map = (Map<String, T>) redisManager.getHash(key);
				if (!map.isEmpty()) {
					redisCache.setHashCache(map);
				}
				break;
			case SET:
				Set<T> set = (Set<T>) redisManager.getSet(key);
				if (!set.isEmpty()) {
					redisCache.setSetCache(set);
				}
				break;
			default:
				break;

			}
			redisCache.setKey(key);
		} catch (Exception e) {
			BaseLogger.error(e);
			return new ResultVO<RedisCache<T>>(ResMsg.QUERY_EXCEPTION.getErrorCode(),
					ResMsg.QUERY_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<RedisCache<T>>(redisCache);
	}

	/**
	 * 增加缓存
	 */
	@Override
	public ResultVO<Boolean> addRedisCache(RedisCache<T> record) {
		try {
			String key = record.getKey();
			if (StringUtil.isEmpty(key)) {
				return new ResultVO<Boolean>(ResMsg.COM_EXCEPTION.getErrorCode(), "缓存缺少key键");
			}
			if (StringUtil.isNotEmpty(record.getValue())) {
				redisManager.set(key, record.getValue(), record.getTimeOut(), record.getTimeUnit());
			}
			if (StringUtil.isNotEmpty(record.getListCache())) {
				redisManager.setList(key, record.getListCache());
			}
			if (StringUtil.isNotEmpty(record.getHashCache())) {
				redisManager.setHash(key, record.getHashCache());
			}
			if (StringUtil.isNotEmpty(record.getSetCache())) {
				redisManager.setSet(key, record.getSetCache());
			}
		} catch (Exception e) {
			BaseLogger.error(e);
			return new ResultVO<Boolean>(ResMsg.ADD_EXCEPTION.getErrorCode(), ResMsg.ADD_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}
    /**
     * 删除缓存
     */
	@Override
	public ResultVO<Boolean> deleteRedisCache(String key) {
		try {
			redisManager.delete(key);
		} catch (Exception e) {
			BaseLogger.error(e);
			return new ResultVO<Boolean>(ResMsg.DELETE_EXCEPTION.getErrorCode(),ResMsg.DELETE_EXCEPTION.getErrorMsg());
		}
		return new ResultVO<Boolean>(true);
	}

}
