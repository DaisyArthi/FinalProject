package com.niit.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.niit.model.Blog;

@EnableTransactionManagement
@Configuration
@ComponentScan("com.niit")
public class ApplicationConfig {

	public static Logger logger = Logger.getLogger("ApplicationConfig");

	public DataSource getOracleDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("hr");
		driverManagerDataSource.setPassword("hr");
		return driverManagerDataSource;
	}

	
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);

		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}

	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
		System.out.println("Blog DAO object Created");
		return new BlogDAOImpl(sessionFactory);
	}

}