package cn.com.component.shiro.session.manager;

import java.io.Serializable;

import org.apache.shiro.session.Session;

public interface ShiroSessionRepository {
  //增加session
  public void save(Session session);
  //删除session
  public void delete(Serializable id);
  //获取session
  public Session getSession(Serializable id);
}
