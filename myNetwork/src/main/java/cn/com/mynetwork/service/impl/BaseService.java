package cn.com.mynetwork.service.impl;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class BaseService {
	//事务回滚
   public void rollback(){
	   TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
   }
}
