package com.example.demo.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("sub33")
public class Controller33 {

	@GetMapping("mylogin")
	public void loginForm() {
		
	}
	
	@GetMapping("loginSuccess")
	public void loginSuccess() {
		
	}
	
	@GetMapping("viewAuth")
	public void viewAuth(Authentication authentication) {
		System.out.println(" 로그인 정보 확인");
		
		System.out.println(authentication);
		System.out.println(authentication.name());
	
		
	}
	
	@GetMapping("customCheck")
	@PreAuthorize("@securityUtil.checkBoardWriter(authentication,#id)")
	public void customCheck(String id) { //받아온 id 파라미터를 #id로 같이 보내줌
		System.out.println("customCheck 메소드 실행");
	}
}

