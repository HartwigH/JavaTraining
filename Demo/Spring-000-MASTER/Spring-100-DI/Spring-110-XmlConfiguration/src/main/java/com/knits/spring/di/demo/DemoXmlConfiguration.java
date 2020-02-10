package com.knits.spring.di.demo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.knits.spring.common.service.MyService;
import com.knits.spring.common.service.ServiceWithCollections;
import com.knits.spring.common.service.UserService;
import com.knits.spring.common.utils.Mocks;
import com.knits.spring.sf.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoXmlConfiguration {

	public static void main(String[] args) {
		
		//demo01_getUserByType();
		//demo02_getUserById();		
		//demo03_getUserByName();
		//demo04_getUserFrom_BeanFactory();
		//demo05_getUserFrom_ApplicationCtxImpls();		
		//demo06_collectionInjection();
		salesFinderDemo();
	}
	
	private static void salesFinderDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo-beans.xml");
		//DataSource ds = context.getBean(DataSource.class);
		DemoService demoService = context.getBean("DemoServiceBean", DemoService.class);
		
		demoService.readAllProducts();
		demoService.readProductsByVisibility();
		demoService.readProductsByUnvisible();
		demoService.readProductIdByNames("Jacket", "Na");
		demoService.readRecentProductId();
		demoService.editProductVisibility(10, 1);		
		//demoService.createNewProduct();
	}
	
	private static void demo01_getUserByType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService =  context.getBean(UserService.class);
		userService.save(Mocks.mockUser());
		
	}
	
	private static void demo02_getUserById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService = context.getBean("UserServiceBean",UserService.class);
		userService.save(Mocks.mockUser());
		
		MyService myService = context.getBean("MyServiceBean",MyService.class);
		myService.feature(Mocks.mockUser());
	}

	private static void demo03_getUserByName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService =  context.getBean("UserServiceName",UserService.class);
		userService.save(Mocks.mockUser());
	}
	
	
	private static void demo04_getUserFrom_BeanFactory(){
		Resource res = new ClassPathResource("spring-beans.xml");
        BeanFactory factory = new XmlBeanFactory(res);	
        UserService userService =  factory.getBean(UserService.class);
        userService.save(Mocks.mockUser());
	}

	
	private static void demo05_getUserFrom_ApplicationCtxImpls(){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/temp/Spring/Spring-100/spring-beans.xml");
		UserService userService =  context.getBean(UserService.class);
		userService.save(Mocks.mockUser());
	}
	
	private static void demo06_collectionInjection(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		ServiceWithCollections service=context.getBean(ServiceWithCollections.class);
		log.info("List: {} ",service.getTechnologySkillsList().toString());
		log.info("Set: {} ",service.getTechnologySkillsSet().toString());
		log.info("Map: {} ",service.getTechnologySkillsMap().toString());
	}
}
