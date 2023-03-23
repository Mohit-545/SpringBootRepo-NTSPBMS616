//OracleConfigDB.java
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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repo.prod",
												entityManagerFactoryRef = "oracleEMF",
												transactionManagerRef = "oracleTxMgmr")
public class OracleConfigDB {
	
	//create dataSource
	@Bean
	@ConfigurationProperties(prefix = "oracle.ds")
	@Primary
	public DataSource createOracleDS() {
		return DataSourceBuilder.create().build();
	}//method
	
	
	//create and return LocalContainerEntityManagerObject which makes EntityManagerFactory as the Spring bean
	@Bean(name = "oracleEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		//create Map object having Hibernate properties
		Map<String, Object> props = new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		return builder.dataSource(createOracleDS())	//datasource details
				.packages("com.nt.model.prod")					//model class pkg
				.properties(props)												//hibernate properties
				.build();
	}//method
	
	
	//create TransactionManager Object
	@Bean(name = "oracleTxMgmr")
	@Primary
	public PlatformTransactionManager createOracleTxMgmr(@Qualifier("oracleEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}//method

}//class
