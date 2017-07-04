package com.roc.provider;/**
 * Created by WanPengCheng on 2017/7/3.
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.IdWorker;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 方法映射
 *
 * @author WanPengCheng
 * @create 2017-07-03-17:21
 **/
public class Parameter implements Serializable {

    private String service;
    private String method;

    private Object[] param;
    private Long id;
    private Map<?,?> map;
    private Page<?> page;
    private List<?> list;

    private final String no = "[" + IdWorker.getId() + "]";

    public Parameter() {}

    public Parameter(String service, String method) {
        this.service = service;
        this.method = method;
    }

    public Parameter(Object result) {
        if (result instanceof Long) {
            this.id = (Long) result;
        } else if (result instanceof Page) {
            this.page = (Page<?>) result;
        } else if (result instanceof  Map<?,?>) {
            this.map = (Map<?,?>) result;
        } else if (result instanceof  List<?>) {
            this.list = (List<?>) result;
        } else {
            this.param = (Object[]) result;
        }
    }

    public String getNo() {
        return no;
    }

    public String getService() {
        return service;
    }

    public Parameter setService(String service) {
        this.service = service;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public Parameter setMethod(String method) {
        this.method = method;
        return this;
    }

    public Object[] getParam() {
        return param;
    }

    public Parameter setParam(Object[] param) {
        this.param = param;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Parameter setId(Long id) {
        this.id = id;
        return this;
    }

    public Map<?, ?> getMap() {
        return map;
    }

    public Parameter setMap(Map<?, ?> map) {
        this.map = map;
        return this;
    }

    public Page<?> getPage() {
        return page;
    }

    public Parameter setPage(Page<?> page) {
        this.page = page;
        return this;
    }

    public List<?> getList() {
        return list;
    }

    public Parameter setList(List<?> list) {
        this.list = list;
        return this;
    }
}
