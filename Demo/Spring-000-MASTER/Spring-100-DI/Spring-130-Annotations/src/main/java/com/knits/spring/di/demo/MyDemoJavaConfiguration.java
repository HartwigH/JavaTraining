package com.knits.spring.di.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knits.spring.di.config.MyDemoConfig;
import com.knits.spring.mydemo.service.PersonService;
import com.knits.spring.sf.service.DemoService;

public class MyDemoJavaConfiguration {

	public static void main(String[] args) {
		myDemo_person();
		mySf_demo();
	}
	
	private static void myDemo_person() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyDemoConfig.class);
		context.getBean(PersonService.class).findPerson();
	}
	
	private static void mySf_demo() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyDemoConfig.class);
		context.getBean(DemoService.class).readAllProducts();
	}
	
}
