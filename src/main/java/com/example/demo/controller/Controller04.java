package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub4")
public class Controller04 {
	// method argument(parameter)
	
	@RequestMapping("link1")
	public void method1(HttpServletRequest request) {
		
		// 1.request parameter 수집/가공 
		String name = request.getParameter("name"); // client 에서 요청한 name parameter 를 name 변수로 가공 
		String age = request.getParameter("age");
		
		// http://localhost:8080/sub4/link1?name=kim&age=13
		System.out.println("name = " + name);
		System.out.println("age = " + age);

	// 2. business logic
		
		
		// 3. add attribute
		
		// 4. forward/redirect
		
	}
	@RequestMapping("link2")
	public void method02(HttpServletRequest request) {
		
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		System.out.println("address = " + address);
		System.out.println("em = " + email);
	}
	
	@RequestMapping("link3")
	public void method03(HttpServletRequest request) {
		
		String game = request.getParameter("game");
			String age = request.getParameter("age");
	
			System.out.println("장르는 : " + game );
			System.out.println("이용가능한 나이 : " + age);
	}
	
	@RequestMapping("link6")
	public void method06(@RequestParam("email") String email) {
		System.out.println(email);
	}
	
	@RequestMapping("link7")
	public void method07(@RequestParam("age") int age) {
		System.out.println("나이는 : " + age);
	}
	
	// 
	
	// 경로 /sub4/link8=seoul
	@RequestMapping("link8")
	public void method08(String address) {
		System.out.println(address);
		
	}
	
	// 경로 /sub4/link9 = score
	
	@RequestMapping("link9")
	public void method09(double score) {
		System.out.println(score);
	}
	
}

