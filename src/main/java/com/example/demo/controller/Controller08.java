package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Dto02;
import com.example.demo.domain.Dto03;
import com.example.demo.domain.Dto04;
import com.example.demo.domain.ProblemCase;

@Controller
@RequestMapping("sub08")

public class Controller08 {

	@RequestMapping("link1")
	public String method1(@ModelAttribute("val")Dto04 dto04) {
		
		// 1. Dto04 dto04 = new Dto04();
		
		dto04.setName("채소");
		dto04.setAge(14);
		
		// 2. model3.addAttribute("product",o4); 
		
		// 1번과 2번을 메소드 아규먼트로 압축함
		
		return "/sub07/link10";
		
	}
	
	@RequestMapping("link2")
	public void method2(@ModelAttribute("product") Dto02 obj) {
		// Dto02 객체를 obj라는 이름으로 생성, 
		// obj를 product 라는 modelAttribute에 저장
		
		obj.setCompany("lol");
		obj.setModel("AOS");
		obj.setPrice(32600);
		
		
	}
	
// ********************  줄이기전 ****************//
	@RequestMapping("link3")
	public void method3(Model model) {
		Dto02 dto02 = new Dto02();
		Dto03 dto03 = new Dto03();
		
		model.addAttribute("product", dto02);
		model.addAttribute("member",dto03);
		
	}
	
	// ********************  생략 후   ****************//	
@RequestMapping("link4")
	public void method4(@ModelAttribute("product") Dto02 dto02, @ModelAttribute("member") Dto03 dto03	) {
	//3. add attribute
	//4. forward
}

//model attribute 의 이름을 생략하면 클래스이름을 lowerCamelCase 로 자동생성

@RequestMapping("link5")
public void method5(@ModelAttribute() Dto02 dto02) {
	
	dto02.setCompany("samsung");
	dto02.setModel("Leejaeyoung");
	
	
}

//model attribute 의 이름을 생략하면 클래스이름을 lowerCamelCase 로 자동생성

@RequestMapping("link6")
public void method6(@ModelAttribute()ProblemCase pc) {
	pc.setGame("tarcov");
	pc.setPrice(200000);
	pc.setDamege(3.14);
	//Dto(javaBean)내용 설정은 새로생성한 객체 pc 로 
	//view 파일에서는 자동 생성된 modelattribute 이름인 problemCase 로 호출
	
}


}