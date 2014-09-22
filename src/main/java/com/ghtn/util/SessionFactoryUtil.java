package com.ghtn.util;

import com.ghtn.context.SessionFactoryContextHolder;
import com.ghtn.context.SessionFactoryType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * User: Administrator
 * Date: 13-12-24
 * Time: 下午3:13
 */
public class SessionFactoryUtil {
    private static Log log = LogFactory.getLog(SessionFactoryUtil.class);

    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        if (methodName.toUpperCase().contains("MYSQL")) {
            log.info("切换到sessionFactory : mysql");
            SessionFactoryContextHolder.setType(SessionFactoryType.mysql);
        }
        if (methodName.toUpperCase().contains("ORACLE")) {
            log.info("切换到sessionFactory : oracle");
            SessionFactoryContextHolder.setType(SessionFactoryType.oracle);
        }
        if (methodName.toUpperCase().contains("SQLSERVER")) {
            log.info("切换到sessionFactory : sqlServer");
            SessionFactoryContextHolder.setType(SessionFactoryType.sqlServer);
        }
        if (methodName.toUpperCase().contains("POSTGRESQL")) {
            log.info("切换到sessionFactory : postgreSql");
            SessionFactoryContextHolder.setType(SessionFactoryType.postgreSql);
        }
    }
}
