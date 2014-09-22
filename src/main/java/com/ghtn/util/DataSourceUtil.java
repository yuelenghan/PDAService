package com.ghtn.util;

import com.ghtn.context.DataSourceContextHolder;
import com.ghtn.context.DataSourceType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * User: Administrator
 * Date: 13-12-23
 * Time: 下午5:29
 */
public class DataSourceUtil {

    private static Log log = LogFactory.getLog(DataSourceUtil.class);

    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        if (methodName.toUpperCase().contains("DATASOURCE1")) {
            log.info("切换到数据源 : dataSource1");
            DataSourceContextHolder.setType(DataSourceType.dataSource1);
        }
        if (methodName.toUpperCase().contains("DATASOURCE2")) {
            log.info("切换到数据源 : dataSource2");
            DataSourceContextHolder.setType(DataSourceType.dataSource2);
        }
        if (methodName.toUpperCase().contains("DATASOURCE3")) {
            log.info("切换到数据源 : dataSource3");
            DataSourceContextHolder.setType(DataSourceType.dataSource3);
        }
        if (methodName.toUpperCase().contains("DATASOURCE4")) {
            log.info("切换到数据源 : dataSource4");
            DataSourceContextHolder.setType(DataSourceType.dataSource4);
        }
        if (methodName.toUpperCase().contains("DATASOURCE5")) {
            log.info("切换到数据源 : dataSource5");
            DataSourceContextHolder.setType(DataSourceType.dataSource5);
        }
        if (methodName.toUpperCase().contains("DATASOURCE6")) {
            log.info("切换到数据源 : dataSource6");
            DataSourceContextHolder.setType(DataSourceType.dataSource6);
        }
        if (methodName.toUpperCase().contains("DATASOURCE7")) {
            log.info("切换到数据源 : dataSource7");
            DataSourceContextHolder.setType(DataSourceType.dataSource7);
        }
    }
}
