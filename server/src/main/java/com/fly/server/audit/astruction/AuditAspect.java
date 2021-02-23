package com.fly.server.audit.astruction;

import com.fly.common.astruction.DefineTransactionManager;
import com.fly.common.utils.IdGen;
import com.fly.server.audit.entity.AuditRecordAudit;
import com.fly.server.audit.enums.DataStatusEnum;
import com.fly.server.audit.service.AuditRecordAuditService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;

/**
 * description: 审核切面
 * date: 2021/2/22 19:49
 * version: 1.0
 * @author: LIGEL
 */
@Component
@Aspect
public class AuditAspect {
    @Resource
    private AuditRecordAuditService auditRecordAuditService;

    final IdGen idGen = IdGen.get();

    @Resource
    private DefineTransactionManager manager;
    /**
     * description: 通过环绕增强，在需要加入审核的方法中增加审核流程
     * version: 1.0
     * date: 2021/2/22 14:16
     * author: LIBEL
     * @param proceedingJoinPoint
     * execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
     * 问题：
     * 1. 这里加的事务是不起作用的，拦截的方法执行后抛出异常，该方法的执行结果没办法回滚
     * 2. 这里使用声明式事务，不能实现代理函数一起回滚，使用编程式事务能够实现。对于集体情况，还需要探究为什么声明式事务失效
     * 3. 隐藏问题是，auditTag可能会重复，单都是要百万级后才会产生。
     * @return java.lang.Object
     */
    @Around("@annotation(com.fly.server.audit.astruction.AuditTagAnnotation)")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        TransactionStatus begin= null;
        Object[] args =proceedingJoinPoint.getArgs();
        MethodSignature methodSignature= (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AuditTagAnnotation action= method.getAnnotation(AuditTagAnnotation.class);
        Parameter[] parameters = method.getParameters();
        System.out.println("该方法执行之前：注解式拦截.第一个参数:"+parameters[0].toString());
        System.out.println("自定义注解参数："+action.tableName());
        Class<?> aClass = Class.forName(parameters[0].getParameterizedType().getTypeName());
        Object obj= Class.forName(parameters[0].getParameterizedType().getTypeName()).newInstance();
        System.out.println("反射类路径："+parameters[0].getParameterizedType().getTypeName());
        obj= args[0];
        // 通过id生成算法生成唯一Tag
        long tag= idGen.nextId();
        Field auditTag = aClass.getDeclaredField("auditTag");
        Field dataStatus = aClass.getDeclaredField("dataStatus");
        auditTag.setAccessible(true);
        auditTag.set(obj, tag);
        dataStatus.setAccessible(true);
        dataStatus.set(obj , DataStatusEnum.WAIT_AUDIT.getCode());
        // 回调赋值，不对，这里拿到的是副本，不是函数的实际参数值,下面注释的也可以实现，可以自己赋值参数，这样可以插入多个，应该用于批量插入
            /*Object[] obs = new Object[1];
            obs[0]=obj;
            Object proceed= proceedingJoinPoint.proceed(obs);*/
        // 这里有个问题，当抛出异常时，这里执行的方法无法回滚，暂时没有解决。
        AuditRecordAudit auditRecordAudit = new AuditRecordAudit();
        // 插入审核记录
        auditRecordAudit.setAuditTag(tag);
        auditRecordAudit.setIsAuditUser(0);
        auditRecordAudit.setAppointAuditUser("131313");
        auditRecordAudit.setGmtCreate(LocalDateTime.now());
        auditRecordAudit.setTableName(action.tableName());
        auditRecordAudit.setReasonForApplicat("就是想提交审核了！");
        try {
            begin= manager.begin();
            Object proceed = proceedingJoinPoint.proceed();
            auditRecordAuditService.save(auditRecordAudit);
            //int i= 1/0;
            manager.commit(begin);
        }catch (Exception e){
            e.printStackTrace();
            manager.rollback(begin);
        }finally {

        }
    }
}
