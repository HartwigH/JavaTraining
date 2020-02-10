package com.knits.spring.di.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knits.spring.mydemo.service.*;
import com.knits.spring.sf.service.*;

public class MyDemoClasspathScanning {
	
	public static void main(String[] args) {
		myDemo_person();
		mySf_demo();
	}
	
	private static void myDemo_person() {
		ApplicationContext context = new ClassPathXmlApplicationContext("mydemo-beans.xml");
		context.getBean(PersonService.class).findPerson();
	}
	
	private static void mySf_demo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("mydemo-beans.xml");
		context.getBean(DemoService.class).readAllProducts();
	}

}
