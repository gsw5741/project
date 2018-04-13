package cn.com.component.spring.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//动态连接池
public class MultiDataSource extends AbstractRoutingDataSource{
	private static final ThreadLocal<String> DATA_SOURCE_KEY = new InheritableThreadLocal<String>();
    /**
     * 切换连接池
     * @param dataSource
     */
    public static void setDataSourceKey(String dataSource) {
    	DATA_SOURCE_KEY.set(dataSource);
    }
    /**
     * 返回跳转的数据源key
     */
	@Override
	protected Object determineCurrentLookupKey() {
		
		return DATA_SOURCE_KEY.get();
	}
  
	
}
