package cn.com.component.shiro.session.manager;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.session.Session;


public class JedisSessionRespository implements ShiroSessionRepository {
	private static ConcurrentHashMap<Object, Object> sessionMap=new ConcurrentHashMap<Object, Object>();
    
	public static ConcurrentHashMap<Object, Object> getSessionMap() {
		return sessionMap;
	}

	//增加session
	@Override
	public void save(Session session) {
		Serializable sessionId=session.getId();
		if(sessionMap.containsKey(sessionId)){
			sessionMap.remove(sessionId);//如果session存在，重新保存
			
		}
	
		

	}
	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}
	@Override
	public Session getSession(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
