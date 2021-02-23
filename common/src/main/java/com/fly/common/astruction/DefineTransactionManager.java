package com.fly.common.astruction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.annotation.Resource;

/**
 * description: 自定义事务处理器
 * date: 2021/2/23 21:16
 * version: 1.0
 * @author: LIGEL
 */
@Component
public class DefineTransactionManager {
    /**
     * description: 这里还是用的系统提供的事务处理器
     * version: 1.0 
     * date: 2021/2/23 21:33 
     * @author: LIGEL
     * @param null
     * @return 
     */ 
    @Resource
    private DataSourceTransactionManager manager;

    /**
     * description: 开启事务 
     * version: 1.0 
     * date: 2021/2/23 21:28 
     * @author: LIGEL
     * @param 
     * @return org.springframework.transaction.TransactionStatus
     */ 
    public TransactionStatus begin() {
        // TransactionStatus是事务的核心, 存储着事务的相关配置信息
        TransactionStatus transaction = manager.getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }

    /**
     * description: 提交事务
     * version: 1.0 
     * date: 2021/2/23 21:28 
     * @author: LIGEL
     * @param transaction
     * @return void
     */ 
    public void commit(TransactionStatus transaction){
        //提交到数据库， 最终用到的还是 AbstractPlatformTransactionManager事务操作类中的方法
        manager.commit(transaction);
    }

    /**
     * description: 事务回滚
     * version: 1.0
     * date: 2021/2/23 21:31
     * @author: LIGEL
     * @param transaction
     * @return void
     */
    public void rollback(TransactionStatus transaction){
        manager.rollback(transaction);
    }


}
