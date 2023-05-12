package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Controller
@RequestMapping("sub34")
public class Controller34 {

	@GetMapping("ajax1")
	public void ajax1() {
		System.out.println("hello AJAX!");
		
		
	}
	
	
	@GetMapping("link1")
	@ResponseBody
	public String method1() {
		
		return "첫번째";
	}

	@GetMapping("link2")
	@ResponseBody
	public String method2() {
		
		return "second";
		
	}
	
	@GetMapping("link3")
	@ResponseBody
	public void method3(@RequestParam("name") String name) {
		
		System.out.println("name : "+ name);
	}

	
	
	@GetMapping("link4")
	public void method4(@RequestParam("address") String address) {
		
		String ad =  "address = " + address;
		
		System.out.println(ad);
	}
	
	// /sub34/link5?name=손&age=22
	@GetMapping("link5")
	public void method5(String name, Integer age) {
		System.out.println("name=" + name);
		System.out.println("age:" + age);
	}
	
	
	@GetMapping("link6")
	
	public void method6(String food, Double price)	{
		System.out.println("food:" + food);
		System.out.println("price:" + price);
	}
	
	@Data
	static class Dto12{
		private String address;
		private String name;
		private Integer age;
	}
	
	// /sub34/link7?address=seoul&name=park&age=33
	@GetMapping("link7")
	public void method7(@ModelAttribute Dto12 dto) {
		System.out.println(dto.name);
		System.out.println(dto.age);
		System.out.println(dto.address);
		System.out.println(dto);
	}
	
	 
	
	@Data
	static class Dto2{
		private Double price;
		private String product;
		private String category;
		}
	
	@GetMapping("link8")
	public void method8(Dto2 dto) {
		System.out.println(dto);
	}
	
}
