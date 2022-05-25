package org.example.hibernate.util;


import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {


    public static Configuration buildConfiguration(){
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        return configuration;
    }

    private static SessionFactory sessionFactoryBuilder(){
        return buildConfiguration().configure().buildSessionFactory();
    }

    public static Session openSession(){
        return sessionFactoryBuilder().openSession();
    }

}
