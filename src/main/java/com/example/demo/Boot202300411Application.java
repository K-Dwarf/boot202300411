package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.domain.Employees;

@SpringBootApplication
public class Boot202300411Application {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Boot202300411Application.class, args);
		Object o = context.getBean("bean1");
		System.out.println(o);
		
		Object o2 = context.getBean("bean2");
		System.out.println(o2);
	}

	public void legacy() {
		Object o = new Object(); // 직접 만든 객체
		Employees e = new Employees(); // 직접 만든 객체
		e.setId(100); // 프로퍼티 직접 할당
	}
	
	
}
