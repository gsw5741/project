package cn.com.component.spring.data.redis.manager;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;


/**
 * redis数据管理
 *
 */
public class RedisManager{
	private RedisTemplate<String,Object> redisTemplate;

	public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
    public DataType getDataType(String key){
    	return redisTemplate.type(key);
    }
	public void set(String key,Object value,Long timeOut,TimeUnit unit){
		ValueOperations<String , Object> valueOperations = redisTemplate.opsForValue();
		if(timeOut!=null&&unit!=null){
			valueOperations.set(key,value,timeOut,unit);
		}else{
			valueOperations.set(key,value);
		}
		
	}
	
	public Object get(String key){
		ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
		return valueOperations.get(key);
	}

	public void setList(String key,List<?> value){
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		listOperations.leftPush(key,value);
	}
	
	public Object getList(String key){
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		return listOperations.leftPop(key);
	}
	
	public void setSet(String key,Set<?> value){
		SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
		setOperations.add(key,value);
	}
	
	public Object getSet(String key){
		SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
		return setOperations.members(key);
	}
	public void setHash(String key,Map<String,?> value){
		HashOperations<String, String, Object> hanshOperations = redisTemplate.opsForHash();
		hanshOperations.putAll(key,value);
	}
	public Object getHash(String key){
		HashOperations<String, String, Object> hanshOperations = redisTemplate.opsForHash();
		return hanshOperations.entries(key);
	}
	public void delete(String key){
		redisTemplate.delete(key);
	
	}
}
