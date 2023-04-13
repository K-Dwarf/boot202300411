package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sub5")

public class Controller05 {
	@RequestMapping("link1")
	public void method01(@RequestParam("name") String name,
						 @RequestParam("age") int age,
						 @RequestParam("score")double score) {
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(score);
		
		
	}
	
	
@RequestMapping("link2")
	public void method02(String name, int age, double score) {
	System.out.println(name);
	System.out.println(age);
	System.out.println(score);
	
}

@RequestMapping("link3")
public void method01(String address, double height, double weight) {
	System.out.println(address);
	System.out.println(height);
	System.out.println(weight);
}






	
}
