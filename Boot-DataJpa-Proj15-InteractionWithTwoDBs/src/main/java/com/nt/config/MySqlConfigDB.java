//MySqlConfigDB.java
package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repo.promos",
												entityManagerFactoryRef = "mysqlEMF",
												transactionManagerRef = "mysqlTxMgmr")
public class MySqlConfigDB {
	
	
	//create dataSource
	@Bean
	@ConfigurationProperties(prefix = "mysql.ds")
	public DataSource createMySqlDS() {
		return DataSourceBuilder.create().build();
	}//method
	
	
	//create and return LocalContainerEntityManagerObject which makes EntityManagerFactory as the Spring bean
	@Bean(name = "mysqlEMF")
	public LocalContainerEntityManagerFactoryBean createMySqlEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		//create Map object having Hibernate properties
		Map<String, Object> props = new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		return builder.dataSource(createMySqlDS())	//datasource details
				.packages("com.nt.model.promos")					//model class pkg
				.properties(props)												//hibernate properties
				.build();
	}//method
	
	
	//create TransactionManager Object
	@Bean(name = "mysqlTxMgmr")
	public PlatformTransactionManager createMySqlTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}//method

}//class
