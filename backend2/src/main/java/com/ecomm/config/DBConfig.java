package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Category;
import com.ecomm.model.Product;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConfig 
{
	//DriverManager datasource need to be created
		@Bean(name="dataSource")
		public DataSource getH2DataSource()
		{
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/project1");
			dataSource.setUsername("sa");
			dataSource.setPassword("sa");
			System.out.println("DataSource Created");
			return dataSource;
		}
		//SessionFactory need to be created
		
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			Properties hibernateProperties=new Properties();
			hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			
			LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
			factory1.addProperties(hibernateProperties);
			factory1.scanPackages("com");
			factory1.addAnnotatedClass(Category.class);
			factory1.addAnnotatedClass(Product.class);
			SessionFactory sessionFactory=factory1.buildSessionFactory();
			
			System.out.println("===Creating the SessionFactory Bean=====");
			return sessionFactory;
			
		}
		//HibernateTransactionManager object need to created
		@Bean(name="hibernateTransactionManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("Hibernate Transaction manager object created");
			return new HibernateTransactionManager(sessionFactory);
		}


}
