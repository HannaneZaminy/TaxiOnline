package ir.maktab.configoration;

import ir.maktab.data.domain.Account;
import ir.maktab.data.domain.Driver;
import ir.maktab.data.domain.Passenger;
import ir.maktab.data.domain.Trip;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Scanner;

@Configuration
@ComponentScan("ir.maktab")
public class Config {
//    private static final SessionFactory sessionFactory = getSessionFactory();

    @Bean("scanner")
    public static Scanner getScanner(){
        return new Scanner(System.in);
    }


    @Bean("sessionFactory")
    public static SessionFactory getSessionFactory() {
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
        cfg.addAnnotatedClass(Account.class);
        cfg.addAnnotatedClass(Passenger.class);
        cfg.addAnnotatedClass(Trip.class);
        cfg.addAnnotatedClass(Driver.class);
        cfg.setProperties(new Properties(){

            {
                put("hibernate.connection.username","root");
                put("hibernate.connection.password","1377722");
                put("hibernate.hibernate.hbm2ddl.auto","create");
                put("hibernate.connection.url","jdbc:mysql://localhost:3307/taxiService");
                put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
            }
        });
        return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
    }
}
