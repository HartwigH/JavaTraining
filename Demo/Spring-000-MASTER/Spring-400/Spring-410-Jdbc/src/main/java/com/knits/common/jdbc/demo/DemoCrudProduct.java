package com.knits.common.jdbc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.common.jdbc.config.MyAppConfig;
import com.knits.common.jdbc.dao.ProductDao;
import com.knits.spring.common.model.Product;

public class DemoCrudProduct {
	
	public static void main(String[] args) {
		sample("ProductDaoJdbcSupportImpl");
		
	}

	
	private static void sample(String daoBeanImpl) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
		ProductDao productDao= context.getBean(daoBeanImpl,ProductDao.class);
		Product product = (Product) productDao.readProducts();
	}
}
