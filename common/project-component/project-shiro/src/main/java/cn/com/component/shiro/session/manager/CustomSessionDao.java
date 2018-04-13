package cn.com.component.shiro.session.manager;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.data.redis.serializer.SerializationUtils;

import cn.com.common.util.SerializableUtil;
import cn.com.component.spring.data.redis.manager.RedisManager;
/**
 * 自定义session管理
 *
 */
public class CustomSessionDao extends AbstractSessionDAO {
    private RedisManager redisManager;
    
    
	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		// TODO Auto-generated method stub

	}
   /**
    * 删除会话
    */
	@Override
	public void delete(Session session) {
		
       redisManager.delete(session.getId().toString());
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		//redisManager.set(key, value, timeOut, unit);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
