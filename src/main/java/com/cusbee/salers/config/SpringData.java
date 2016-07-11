package com.cusbee.salers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.cusbee.salers.repository")
public class SpringData extends WebMvcConfigurerAdapter {

    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String MAX_SIZE = "hibernate.c3p0.max_size";
    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "com.cusbee.salers.entity";

    @Bean
    public DataSource dataSource() {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource
                    .setUrl("jdbc:mysql://localhost:3306/cabin?autoReconnect=true&amp;createDatabaseIfNotExist=true&amp;");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        em.setDataSource(dataSource());

        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setShowSql(false);
        em.setJpaVendorAdapter(vendor);
        em.setJpaProperties(hibProperties());
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put(HIBERNATE_HBM2DDL_AUTO, "update");
        properties.put(HIBERNATE_SHOW_SQL, "false");
        properties.put(MAX_SIZE, 25);
        return properties;
    }
}