package kata.jdbc.util;

import kata.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost:3306/my_db";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static SessionFactory sessionFactory = null;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/my_db");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

//    public static SessionFactory getConnection() {
//
//        try {
//            Configuration configuration = new Configuration()
//                    .setProperty("hibernate.connection.driver_class", DRIVER)
//                    .setProperty("hibernate.connection.url", HOST)
//                    .setProperty("hibernate.connection.username", LOGIN)
//                    .setProperty("hibernate.connection.password", PASSWORD)
//                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
//                    .addAnnotatedClass(User.class)
//                    .setProperty("hibernate.c3p0.min_size","5")
//                    .setProperty("hibernate.c3p0.max_size","200")
//                    .setProperty("hibernate.c3p0.max_statements","200");
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//        return sessionFactory;
//    }
}


