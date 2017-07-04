package com.roc.provider;/**
 * Created by WanPengCheng on 2017/7/3.
 */

/**
 * 实现
 *
 * @author WanPengCheng
 * @create 2017-07-03-17:32
 **/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.esotericsoftware.reflectasm.MethodAccess;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.alibaba.fastjson.JSON;

public abstract class SysProviderImpl implements ApplicationContextAware, ISysProvider {
    protected static Logger logger = LogManager.getLogger();
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Parameter execute(Parameter parameter) {
        String no = parameter.getNo();
        logger.info("{} request：{}", no, JSON.toJSONString(parameter));
        Object service = applicationContext.getBean(parameter.getService());
        try {
            Long id = parameter.getId();
            Page<?> page = parameter.getPage();
            List<?> list = parameter.getList();
            Map<?, ?> map = parameter.getMap();
            String method = parameter.getMethod();
            Object[] param = parameter.getParam();
            Object result = null;
            if (param != null) {
                result = invokeMethod(service, method, param);
            } else if (id != null) {
                result = invokeMethod(service, method, id);
            } else if (page != null) {
                result = invokeMethod(service, method, page);
            } else if (list != null) {
                result = invokeMethod(service, method, list);
            } else if (map != null) {
                result = invokeMethod(service, method, map);
            } else {
                result = invokeMethod(service, method);
            }
            if (result != null) {
                Parameter response = new Parameter(result);
                logger.info("{} response：{}", no, JSON.toJSONString(response));
                return response;
            }
            logger.info("{} response empty.", no);
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Map<String, MethodAccess> methodMap = new HashMap<String, MethodAccess>();
    /**
     * 执行某对象方法
     *
     * @param owner
     *            对象
     * @param methodName
     *            方法名
     * @param args
     *            参数
     * @return 方法返回值
     */
    public static final Object invokeMethod(Object owner, String methodName, Object... args) {
        Class<?> ownerClass = owner.getClass();
        String key = null;
        if (args != null) {
            Class<?>[] argsClass = new Class[args.length];
            for (int i = 0, j = args.length; i < j; i++) {
                if (args[i] != null) {
                    argsClass[i] = args[i].getClass();
                }
            }
            key = ownerClass + "_" + methodName + "_" + StringUtils.join(argsClass, ","); // 用于区分重载的方法
        } else {
            key = ownerClass + "_" + methodName; // 用于区分重载的方法
        }
        MethodAccess methodAccess = methodMap.get(key);
        if (methodAccess == null) {
            methodAccess = MethodAccess.get(ownerClass);
            methodMap.put(key, methodAccess); // 缓存Method对象
        }
        return methodAccess.invoke(owner, methodName, args);
    }
}