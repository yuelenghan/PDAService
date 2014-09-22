package com.ghtn.context;

import org.hibernate.*;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

/**
 * User: Administrator
 * Date: 13-12-24
 * Time: 上午10:48
 */
public class DynamicSessionFactoryImpl implements DynamicSessionFactory {

    private Map<Object, SessionFactory> targetSessionFactorys;
    private SessionFactory defaultTargetSessionFactory;

    public void setTargetSessionFactorys(Map<Object, SessionFactory> targetSessionFactorys) {
        this.targetSessionFactorys = targetSessionFactorys;
    }

    public void setDefaultTargetSessionFactory(SessionFactory defaultTargetSessionFactory) {
        this.defaultTargetSessionFactory = defaultTargetSessionFactory;
    }

    @Override
    public SessionFactory getHibernateSessionFactory() {
        if (SessionFactoryContextHolder.getType() == null) {
            return defaultTargetSessionFactory;
        }
        SessionFactory targetSessionFactory = targetSessionFactorys.get(SessionFactoryContextHolder.getType().toString());
        if (targetSessionFactory != null) {
            return targetSessionFactory;
        } else if (defaultTargetSessionFactory != null) {
            return defaultTargetSessionFactory;
        }
        return null;
    }

    @Override
    public SessionFactoryOptions getSessionFactoryOptions() {
        return null;
    }

    /**
     * Obtain a {@link Session} builder.
     *
     * @return The session builder
     */
    @Override
    public SessionBuilder withOptions() {
        return null;
    }

    /**
     * Open a {@link org.hibernate.Session}.
     * <p/>
     * JDBC {@link Connection connection(s} will be obtained from the
     * configured {@link org.hibernate.service.jdbc.connections.spi.ConnectionProvider} as needed
     * to perform requested work.
     *
     * @return The created session.
     * @throws org.hibernate.HibernateException Indicates a problem opening the session; pretty rare here.
     */
    @Override
    public Session openSession() throws HibernateException {
        return null;
    }

    /**
     * Obtains the current session.  The definition of what exactly "current"
     * means controlled by the {@link org.hibernate.context.spi.CurrentSessionContext} impl configured
     * for use.
     * <p/>
     * Note that for backwards compatibility, if a {@link org.hibernate.context.spi.CurrentSessionContext}
     * is not configured but JTA is configured this will default to the {@link org.hibernate.context.internal.JTASessionContext}
     * impl.
     *
     * @return The current session.
     * @throws org.hibernate.HibernateException Indicates an issue locating a suitable current session.
     */
    @Override
    public Session getCurrentSession() throws HibernateException {
        return null;
    }

    /**
     * Obtain a {@link org.hibernate.StatelessSession} builder.
     *
     * @return The stateless session builder
     */
    @Override
    public StatelessSessionBuilder withStatelessOptions() {
        return null;
    }

    /**
     * Open a new stateless session.
     *
     * @return The created stateless session.
     */
    @Override
    public StatelessSession openStatelessSession() {
        return null;
    }

    /**
     * Open a new stateless session, utilizing the specified JDBC
     * {@link java.sql.Connection}.
     *
     * @param connection Connection provided by the application.
     * @return The created stateless session.
     */
    @Override
    public StatelessSession openStatelessSession(Connection connection) {
        return null;
    }

    /**
     * Retrieve the {@link org.hibernate.metadata.ClassMetadata} associated with the given entity class.
     *
     * @param entityClass The entity class
     * @return The metadata associated with the given entity; may be null if no such
     * entity was mapped.
     * @throws org.hibernate.HibernateException Generally null is returned instead of throwing.
     */
    @Override
    public ClassMetadata getClassMetadata(Class entityClass) {
        return null;
    }

    /**
     * Retrieve the {@link org.hibernate.metadata.ClassMetadata} associated with the given entity class.
     *
     * @param entityName The entity class
     * @return The metadata associated with the given entity; may be null if no such
     * entity was mapped.
     * @throws org.hibernate.HibernateException Generally null is returned instead of throwing.
     * @since 3.0
     */
    @Override
    public ClassMetadata getClassMetadata(String entityName) {
        return null;
    }

    /**
     * Get the {@link org.hibernate.metadata.CollectionMetadata} associated with the named collection role.
     *
     * @param roleName The collection role (in form [owning-entity-name].[collection-property-name]).
     * @return The metadata associated with the given collection; may be null if no such
     * collection was mapped.
     * @throws org.hibernate.HibernateException Generally null is returned instead of throwing.
     */
    @Override
    public CollectionMetadata getCollectionMetadata(String roleName) {
        return null;
    }

    /**
     * Retrieve the {@link org.hibernate.metadata.ClassMetadata} for all mapped entities.
     *
     * @return A map containing all {@link org.hibernate.metadata.ClassMetadata} keyed by the
     * corresponding {@link String} entity-name.
     * @throws org.hibernate.HibernateException Generally empty map is returned instead of throwing.
     * @since 3.0 changed key from {@link Class} to {@link String}.
     */
    @Override
    public Map<String, ClassMetadata> getAllClassMetadata() {
        return null;
    }

    /**
     * Get the {@link org.hibernate.metadata.CollectionMetadata} for all mapped collections
     *
     * @return a map from <tt>String</tt> to <tt>CollectionMetadata</tt>
     * @throws org.hibernate.HibernateException Generally empty map is returned instead of throwing.
     */
    @Override
    public Map getAllCollectionMetadata() {
        return null;
    }

    /**
     * Retrieve the statistics fopr this factory.
     *
     * @return The statistics.
     */
    @Override
    public Statistics getStatistics() {
        return null;
    }

    /**
     * Destroy this <tt>SessionFactory</tt> and release all resources (caches,
     * connection pools, etc).
     * <p/>
     * It is the responsibility of the application to ensure that there are no
     * open {@link org.hibernate.Session sessions} before calling this method as the impact
     * on those {@link org.hibernate.Session sessions} is indeterminate.
     * <p/>
     * No-ops if already {@link #isClosed closed}.
     *
     * @throws org.hibernate.HibernateException Indicates an issue closing the factory.
     */
    @Override
    public void close() throws HibernateException {

    }

    /**
     * Is this factory already closed?
     *
     * @return True if this factory is already closed; false otherwise.
     */
    @Override
    public boolean isClosed() {
        return false;
    }

    /**
     * Obtain direct access to the underlying cache regions.
     *
     * @return The direct cache access API.
     */
    @Override
    public Cache getCache() {
        return null;
    }

    /**
     * Evict all entries from the second-level cache. This method occurs outside
     * of any transaction; it performs an immediate "hard" remove, so does not respect
     * any transaction isolation semantics of the usage strategy. Use with care.
     *
     * @param persistentClass The entity class for which to evict data.
     * @throws org.hibernate.HibernateException Generally will mean that either that
     *                                          'persisttentClass' did not name a mapped entity or a problem
     *                                          communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictEntityRegion(Class)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evict(Class persistentClass) throws HibernateException {

    }

    /**
     * Evict an entry from the second-level  cache. This method occurs outside
     * of any transaction; it performs an immediate "hard" remove, so does not respect
     * any transaction isolation semantics of the usage strategy. Use with care.
     *
     * @param persistentClass The entity class for which to evict data.
     * @param id              The entity id
     * @throws org.hibernate.HibernateException Generally will mean that either that
     *                                          'persisttentClass' did not name a mapped entity or a problem
     *                                          communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#containsEntity(Class, java.io.Serializable)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evict(Class persistentClass, Serializable id) throws HibernateException {

    }

    /**
     * Evict all entries from the second-level cache. This method occurs outside
     * of any transaction; it performs an immediate "hard" remove, so does not respect
     * any transaction isolation semantics of the usage strategy. Use with care.
     *
     * @param entityName The entity name for which to evict data.
     * @throws org.hibernate.HibernateException Generally will mean that either that
     *                                          'persisttentClass' did not name a mapped entity or a problem
     *                                          communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictEntityRegion(String)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evictEntity(String entityName) throws HibernateException {

    }

    /**
     * Evict an entry from the second-level  cache. This method occurs outside
     * of any transaction; it performs an immediate "hard" remove, so does not respect
     * any transaction isolation semantics of the usage strategy. Use with care.
     *
     * @param entityName The entity name for which to evict data.
     * @param id         The entity id
     * @throws org.hibernate.HibernateException Generally will mean that either that
     *                                          'persisttentClass' did not name a mapped entity or a problem
     *                                          communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictEntity(String, java.io.Serializable)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evictEntity(String entityName, Serializable id) throws HibernateException {

    }

    /**
     * Evict all entries from the second-level cache. This method occurs outside
     * of any transaction; it performs an immediate "hard" remove, so does not respect
     * any transaction isolation semantics of the usage strategy. Use with care.
     *
     * @param roleName The name of the collection role whose regions should be evicted
     * @throws org.hibernate.HibernateException Generally will mean that either that
     *                                          'roleName' did not name a mapped collection or a problem
     *                                          communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictCollectionRegion(String)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evictCollection(String roleName) throws HibernateException {

    }

    /**
     * Evict an entry from the second-level cache. This method occurs outside
     * of any transaction; it performs an immediate "hard" remove, so does not respect
     * any transaction isolation semantics of the usage strategy. Use with care.
     *
     * @param roleName The name of the collection role
     * @param id       The id of the collection owner
     * @throws org.hibernate.HibernateException Generally will mean that either that
     *                                          'roleName' did not name a mapped collection or a problem
     *                                          communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictCollection(String, java.io.Serializable)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evictCollection(String roleName, Serializable id) throws HibernateException {

    }

    /**
     * Evict any query result sets cached in the named query cache region.
     *
     * @param cacheRegion The named query cache region from which to evict.
     * @throws org.hibernate.HibernateException Since a not-found 'cacheRegion' simply no-ops,
     *                                          this should indicate a problem communicating with underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictQueryRegion(String)} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evictQueries(String cacheRegion) throws HibernateException {

    }

    /**
     * Evict any query result sets cached in the default query cache region.
     *
     * @throws org.hibernate.HibernateException Indicate a problem communicating with
     *                                          underlying cache impl.
     * @deprecated Use {@link org.hibernate.Cache#evictQueryRegions} accessed through
     * {@link #getCache()} instead.
     */
    @Override
    public void evictQueries() throws HibernateException {

    }

    /**
     * Obtain a set of the names of all filters defined on this SessionFactory.
     *
     * @return The set of filter names.
     */
    @Override
    public Set getDefinedFilterNames() {
        return null;
    }

    /**
     * Obtain the definition of a filter by name.
     *
     * @param filterName The name of the filter for which to obtain the definition.
     * @return The filter definition.
     * @throws org.hibernate.HibernateException If no filter defined with the given name.
     */
    @Override
    public FilterDefinition getFilterDefinition(String filterName) throws HibernateException {
        return null;
    }

    /**
     * Determine if this session factory contains a fetch profile definition
     * registered under the given name.
     *
     * @param name The name to check
     * @return True if there is such a fetch profile; false otherwise.
     */
    @Override
    public boolean containsFetchProfileDefinition(String name) {
        return false;
    }

    /**
     * Retrieve this factory's {@link org.hibernate.TypeHelper}
     *
     * @return The factory's {@link org.hibernate.TypeHelper}
     */
    @Override
    public TypeHelper getTypeHelper() {
        return null;
    }

    /**
     * Retrieves the Reference of this object.
     *
     * @return The non-null Reference of this object.
     * @throws javax.naming.NamingException If a naming exception was encountered
     *                                      while retrieving the reference.
     */
    @Override
    public Reference getReference() throws NamingException {
        return null;
    }
}
