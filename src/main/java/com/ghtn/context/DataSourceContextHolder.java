package com.ghtn.context;

/**
 * User: Administrator
 * Date: 13-12-23
 * Time: 下午4:54
 */
public class DataSourceContextHolder {
    private static final ThreadLocal holder = new ThreadLocal();


    public static void setType(DataSourceType dataSourceType) {
       /* Map<String, Object> contextMap = holder.get();
        contextMap.put("dataSourceType", dataSourceType);*/
        holder.set(dataSourceType);
    }

    public static DataSourceType getType() {
        return (DataSourceType) holder.get();
    }

    public static void clearType() {
//        holder.get().put("dataSourceType", null);
        holder.remove();
    }
}
