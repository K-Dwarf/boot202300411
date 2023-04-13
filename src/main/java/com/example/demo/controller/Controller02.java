package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/sub2")
public class Controller02 {

	
	@RequestMapping("/link1")
	public void method01() {
		System.out.println("/sub2/link1 에서 일함");
	}
	
	
	@RequestMapping("/link2")
	public void method02() {
		System.out.println("/sub2/link2 에서 받아서 일함");
	}
}
