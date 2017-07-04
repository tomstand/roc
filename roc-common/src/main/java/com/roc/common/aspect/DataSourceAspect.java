package com.roc.common.aspect;/**
 * Created by WanPengCheng on 2017/6/29.
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 切换数据源
 * @author WanPengCheng
 * @create 2017-06-29-15:13
 **/
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
    private final Logger logger = LogManager.getLogger();

    @Pointcut("execution(* com.roc.service..*.*(..))")
    public void aspect() {

    }

    @Before("aspect()")
    public void before(JoinPoint point) {
        String className = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        logger.info(className + "." + method + "(" + StringUtils.join(point.getArgs(), ",") + ")");
        try {
            L: for(String key : ChooseDataSource.METHODTYPE.keySet()) {
                for(String type : ChooseDataSource.METHODTYPE.get(key)) {
                    if (method.startsWith(type)){
                        logger.info(key);
                        HandleDataSource.putDataSource(key);
                        break L;
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e);
            HandleDataSource.putDataSource("write");
        }
    }

    @After("aspect()")
    public void after(JoinPoint point) {
        HandleDataSource.clear();
    }

}
