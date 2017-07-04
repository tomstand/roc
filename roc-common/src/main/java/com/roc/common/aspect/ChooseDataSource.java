package com.roc.common.aspect;/**
 * Created by WanPengCheng on 2017/6/29.
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *获取数据源
 *
 * @author WanPengCheng
 * @create 2017-06-29-14:52
 **/
public class ChooseDataSource extends AbstractRoutingDataSource {

    public static Map<String, List<String>> METHODTYPE = new HashMap<String, List<String>>();

    //获取数据源名称
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
    }

    //设置方法名前缀对应的数据源
    public void setMethodType(Map<String, String> map) {
        for (String key : map.keySet()) {
            List<String> v = new ArrayList<String>();
            String[] types = map.get(key).split(",");
            for (String type : types) {
                if (StringUtils.isNoneBlank(type)) {
                    v.add(type);
                }
            }
            METHODTYPE.put(key,v);
        }
    }
}
