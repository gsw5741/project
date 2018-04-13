package cn.com.mybatis.page.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.type.TypeHandler;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.util.StringUtil;

/**
 * * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。 利用拦截器实现Mybatis分页的原理：
 * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，
 * Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句
 * 是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。
 * 在Mybatis中Statement语句是通过RoutingStatementHandler对象的
 * prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，
 * 然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用
 * StatementHandler对象的prepare方法，即调用invocation.proceed()。
 * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的Sql语句后，
 * 把它改为对应的统计语句再利用Mybatis封装好的参数和设 置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, args = { Connection.class }, method = "prepare") })
public class PageInterceptor implements Interceptor {
	private String pageSqlId = ".*listPage.*";
	private String databaseType;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		BaseStatementHandler handler = (BaseStatementHandler) metaStatementHandler.getValue("delegate");
		MappedStatement ms = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		if (ms.getId().matches(this.pageSqlId)) {
			// 分页查询
			BoundSql bs = handler.getBoundSql();
			Object param = bs.getParameterObject();
			String sql = getPageSql(param, bs);// 获取分业sql语句
			BoundSql bsnew = new BoundSql(ms.getConfiguration(), sql, bs.getParameterMappings(), param);
			metaStatementHandler.setValue("delegate.boundSql", bsnew);

		}
		return invocation.proceed();
	}

	// 获取分业sql语句
	public String getPageSql(Object param, BoundSql bs) {
		StringBuilder builder = new StringBuilder();
		if (param instanceof PageVO) {
			PageVO<?> pageVo = (PageVO<?>) param;
			Page<?> page = pageVo.getPage();
			int pageNumber = page.getPageNumber();
			int pageSize = page.getPageSize();
			if ("oracle".equals(databaseType)) {
				// oracle分页
				builder.delete(0, builder.length());
				builder.append("SELECT * FROM (SELECT table_.*,rownum rn from (");
				builder.append(bs.getSql());
				builder.append(") table_ WHERE ROWNUM<=").append(pageNumber * pageSize);
				builder.append(")where rn>").append((pageNumber - 1) * pageSize);

			} else if ("mysql".equals(databaseType)) {
				// mysql 分页
				builder.delete(0, builder.length());
				builder.append("SElECT * FROM (");
				builder.append(bs.getSql());
				builder.append(")table_ limit ").append((pageNumber - 1) * pageSize);
				builder.append(",").append(pageSize);
			}
		}
		return builder.toString();
	}

	@Override
	public Object plugin(Object target) {

		return Plugin.wrap(target, this);
	}

	// 配置属性
	@Override
	public void setProperties(Properties properties) {
		this.databaseType = properties.getProperty("databaseType");
		this.pageSqlId = properties.getProperty("pageSqlId");
	}

	/**
	 * 统计总数
	 * 
	 * @param connection
	 * @param handler
	 * @param mappedStatement
	 * @return
	 * @throws SQLException
	 */
	public int getTotal(Connection connection, BoundSql boundSql, MappedStatement mappedStatement) throws SQLException {
		String sql = boundSql.getSql();
		sql = sql.substring(sql.indexOf("from"));
		//sql语句包含order by
		if(sql.indexOf("order")>-1){
			sql = sql.substring(0, sql.lastIndexOf("order"));
		}
		String countSql = "select count(*) " + sql;
		
		int total = 0;
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			ps = connection.prepareStatement(countSql);
			//参数赋值
			setParameters(boundSql, ps, mappedStatement.getId());
			res = ps.executeQuery();//执行sql语句
			if(res.next()){
				total = res.getInt(1);
			}
		} catch (SQLException e) {
			BaseLogger.error(e);
			e.printStackTrace();
		} finally {
			if (res != null) {
				res.close();
				ps.close();
			}
		}
		return total;
	}
	/**
	 * 参数赋值
	 * @param boundSql
	 * @param ps
	 * @param mappedStatementId
	 * @throws SQLException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected void setParameters(BoundSql boundSql,PreparedStatement ps,String mappedStatementId) throws SQLException{
    	Object param = boundSql.getParameterObject();
    	if(StringUtil.isEmpty(param)){
    		return;
    	}
    	MetaObject metaObject = SystemMetaObject.forObject(param);
    	List<ParameterMapping> paramList = boundSql.getParameterMappings();
    	if(paramList == null){
    		return;
    	}
		for (int index = 0; index < paramList.size(); index++) {
			ParameterMapping parameter = paramList.get(index);
			// 参数类型不是OUT
			if (parameter.getMode() != ParameterMode.OUT) {
				String propertyName = parameter.getProperty();
				Object value = StringUtil.isEmpty(metaObject) ? null : metaObject.getValue(propertyName);
				TypeHandler typeHandler = parameter.getTypeHandler();
				if (typeHandler == null) {
					throw new ExecutorException("There is no TypeHandler for Parameter \"" + propertyName + "\" of statement " + mappedStatementId);
				}
				typeHandler.setParameter(ps, index + 1, value, parameter.getJdbcType());
			}

		}
    }
}
