package com.knits.spring.di.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.knits.spring.mydemo.service", "com.knits.spring.mydemo.dao", "com.knits.spring.sf.service",
		"com.knits.spring.sf.dao" })
public class MyDemoConfig {

	@Bean
	private static BasicDataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sales_finder");
		dataSource.setUsername("root");
		dataSource.setPassword("toor");
		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(10);
		dataSource.setMaxOpenPreparedStatements(100);
		return dataSource;
	}
}
