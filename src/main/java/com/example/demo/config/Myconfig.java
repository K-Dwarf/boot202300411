package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.component.ComponentA;
import com.example.demo.component.ComponentB;
import com.example.demo.domain.Employees;

@Configuration
public class Myconfig {

	// 스프링이 이메소드를 사용해서 객체를 만듦
	// 스프링 빈 (스프링이 관리하는 객체)
	// 빈 이름 == 메소드 이름과 같음
	@Bean
	public Object bean1() {
		return new Object();
	}
	@Bean
	public Object bean2() {
		 return new Employees();
	}
	
	
	@Bean
	public ComponentB bean4() {
		return new ComponentB();
	}
}
