package com.ghtn.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * User: Administrator
 * Date: 13-12-23
 * Time: 下午4:53
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static Log log = LogFactory.getLog(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType key = DataSourceContextHolder.getType();
        log.info("当前数据源 :" + key);
        return key;
    }
}
