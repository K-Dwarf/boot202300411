package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Supplier;
import com.example.demo.mapper.Mapper09;

@Controller
@RequestMapping("sub28")
public class Controller28 {

	@Autowired
	private Mapper09 mapper;
	
	@GetMapping("link1")
	public void method1() {
		mapper.sql1(List.of("uk","USA"));
	}
	
	

		@GetMapping("link2")
		public void method2() {
			List list1 = mapper.sql2(List.of("UK","USA","Japan"));
			list1.forEach(System.out::print);
		}	
	
		@GetMapping("link3")
		public void method3() {
			// sub28/link3.jsp 포워드
		}
			

/*		@GetMapping("link4")
		public void method4(String[] country) {
			System.out.println(Arrays.toString(country)); 
			
		}       아래와 위는 같은 동작을 함                */
		@GetMapping("link4")
		public void method4(@RequestParam(value = "country",required = false) List<String>country) {
			System.out.println(country);
			if(country == null) {
				
			}
			
			mapper.sql2(country).forEach(System.out::println);
			
		}
	
	
}

