package com.roc.common.aspect;/**
 * Created by WanPengCheng on 2017/6/29.
 */

/**
 * @author WanPengCheng
 * @create 2017-06-29-14:56
 **/
public class HandleDataSource {

    //数据源名称线程池
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String dataSource) {
        holder.set(dataSource);
    }

    public static String getDataSource() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }


}
