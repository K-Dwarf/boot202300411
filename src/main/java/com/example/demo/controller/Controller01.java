package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {

	
	@RequestMapping("/sub1/link1") // sub1/link1 경로로 요청이 왔을때 실행 (오타조심)
	public void method01() {
		System.out.println("controller is working now");
	}
	
	@RequestMapping("/sub1/link2")
	public void method02() {
		System.out.println("second controller is working");
	}
	
	@RequestMapping("/sub1/link3")
	public void method3() {
		System.out.println("일하는 request method3");
	}
}
