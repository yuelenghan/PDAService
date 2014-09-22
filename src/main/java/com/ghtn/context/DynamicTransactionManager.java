package com.ghtn.context;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import javax.sql.DataSource;

/**
 * User: Administrator
 * Date: 13-12-24
 * Time: 上午10:49
 */
public class DynamicTransactionManager extends HibernateTransactionManager {
    @Override
    public DataSource getDataSource() {
        return SessionFactoryUtils.getDataSource(getSessionFactory());
    }

    @Override
    public SessionFactory getSessionFactory() {
        DynamicSessionFactory dynamicSessionFactory = (DynamicSessionFactory) super.getSessionFactory();
        SessionFactory hibernateSessionFactory = dynamicSessionFactory.getHibernateSessionFactory();
        return hibernateSessionFactory;
    }
}
