/**
 * 
 */
package com.sparsh.learning.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author prashant.swamy
 *
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();

            // configuration.configure("/src/main/resources/hibernate.cfg.xml");
            configuration.configure();

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

            serviceRegistryBuilder.applySettings(configuration.getProperties());

            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
