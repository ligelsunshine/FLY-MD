package com.fly.server.audit.astruction;

import com.fly.server.audit.enums.DataStatusEnum;
import com.fly.common.utils.IdGen;
import com.fly.server.audit.entity.AuditRecordAudit;
import com.fly.server.audit.service.AuditRecordAuditService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    /**
     * description: 通过环绕增强，在需要加入审核的方法中增加审核流程
     * version: 1.0
     * date: 2021/2/22 14:16
     * author: LIBEL
     * @param proceedingJoinPoint
     * execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
     * 问题：
     * 1. 这里加的事务是不起作用的，拦截的方法执行后抛出异常，该方法的执行结果没办法回滚
     * @return java.lang.Object
     */
    @Around("@annotation(com.fly.server.audit.astruction.AuditTagAnnotation)")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        try {
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
            Object proceed = proceedingJoinPoint.proceed();
            AuditRecordAudit auditRecordAudit = new AuditRecordAudit();
            // 插入审核记录
            // int i=1/0;
            auditRecordAudit.setAuditTag(tag);
            auditRecordAudit.setIsAuditUser(0);
            auditRecordAudit.setAppointAuditUser("131313");
            auditRecordAudit.setGmtCreate(LocalDateTime.now());
            auditRecordAudit.setTableName(action.tableName());
            auditRecordAudit.setReasonForApplicat("就是想提交审核了！");
            auditRecordAuditService.save(auditRecordAudit);
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("后置增强-释放资源！");
        }
    }
}
