package com.ghtn.context;

import org.hibernate.SessionFactory;

/**
 * User: Administrator
 * Date: 13-12-24
 * Time: 上午10:48
 */
public interface DynamicSessionFactory extends SessionFactory {
    public SessionFactory getHibernateSessionFactory();
}
