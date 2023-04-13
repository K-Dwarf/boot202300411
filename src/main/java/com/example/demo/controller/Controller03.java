package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 클래스 자체에 path 맵핑을 걸어주면 
//소속된 메소드들은 기본적으로 해당 path 부터 시작하므로 생략 가능


@Controller
@RequestMapping("/sub3")
public class Controller03 {

	@RequestMapping("/num1") // 생략안된 path는 ("/sub3/num1")이다
	public void method01() {
		System.out.println("/sub3/num1 에서 일함");
	}

	@RequestMapping("/num2")
	public void method02() {
		System.out.println("/sub3/num2 에서 일함");
	}
	
	@RequestMapping("/num3")
	public void method03() {
		System.out.println("/sub3/num3 에서 일함");
	}
	
}
