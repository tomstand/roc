package com.roc.provider;/**
 * Created by WanPengCheng on 2017/7/3.
 */

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WanPengCheng
 * @create 2017-07-03-17:50
 **/
public class AbstractController<T extends ISysProvider> {

    protected final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    protected T sysProvider;


//    public Object query(ModelMap modelMap, Map<String, Object> param) {
//        Parameter parameter = new Parameter(getService(), "query").setMap(param);
//        logger.info("{} execute query start...", parameter.getNo());
//        Page<?> list = provider.execute(parameter).getPage();
//        logger.info("{} execute query end.", parameter.getNo());
//        return setSuccessModelMap(modelMap, list);
//    }
//
//    public Object queryList(ModelMap modelMap, Map<String, Object> param) {
//        Parameter parameter = new Parameter(getService(), "queryList").setMap(param);
//        logger.info("{} execute queryList start...", parameter.getNo());
//        List<?> list = provider.execute(parameter).getList();
//        logger.info("{} execute queryList end.", parameter.getNo());
//        return setSuccessModelMap(modelMap, list);
//    }
//
//    public Object get(ModelMap modelMap, BaseModel param) {
//        Parameter parameter = new Parameter(getService(), "queryById").setId(param.getId());
//        logger.info("{} execute queryById start...", parameter.getNo());
//        BaseModel result = provider.execute(parameter).getModel();
//        logger.info("{} execute queryById end.", parameter.getNo());
//        return setSuccessModelMap(modelMap, result);
//    }
//
//    public Object update(ModelMap modelMap) {
//        Long userId = getCurrUser();
//        if (param.getId() == null) {
//            param.setCreateBy(userId);
//            param.setCreateTime(new Date());
//        }
//        param.setUpdateBy(userId);
//        param.setUpdateTime(new Date());
//        Parameter parameter = new Parameter(getService(), "update").setModel(param);
//        logger.info("{} execute update start...", parameter.getNo());
//        provider.execute(parameter);
//        logger.info("{} execute update end.", parameter.getNo());
//        return setSuccessModelMap(modelMap);
//    }
//
//    public Object delete(ModelMap modelMap) {
//        Parameter parameter = new Parameter(getService(), "delete").setId(param.getId());
//        logger.info("{} execute delete start...", parameter.getNo());
//        provider.execute(parameter);
//        logger.info("{} execute delete end.", parameter.getNo());
//        return setSuccessModelMap(modelMap);
//    }

}
