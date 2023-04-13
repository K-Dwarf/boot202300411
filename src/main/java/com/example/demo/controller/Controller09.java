package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Dto03;
import com.example.demo.domain.Dto04;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub9")
public class Controller09 {

	@RequestMapping("link1")
	public String method01(HttpServletRequest req,Model model	) {
		
		// 1. request parameter 수집/가공
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Dto04 obj = new Dto04();
		obj.setName(name);
		obj.setAge(age);
		
		// 2. business logic
		
		// 3. add attribute	
		
		model.addAttribute("value", obj);
		
		// 4. forward / redirect
		
		// /WEB-INF/view/sub9/link1.jsp 로 포워드
		return "/sub9/link1";
	}

	@RequestMapping("link2")
	public String method2(@ModelAttribute("value") Dto04 obj) {
		return "/sub9/link1";
	}
	
	
	@RequestMapping("link3")
	public void method3(@ModelAttribute("attr")Dto04 dto) {
		// 1. request param 수집/가공
		// Dto04 객체 만들고
		// name 요청 파라미터를 위 객체에 셋팅
		// age 요청 파라미터 위 객체에 셋팅
		
		//3. add attribute 추가
		// 위 객체를 attr 이름으로 model 추가
		
		// 4. forward/ redirect
		// /WEB-INf/views/sub9/link3.jsp로 포워드
		
	}
		
	@RequestMapping("link4")
	public String method4(Dto04 dto){
		
		return "/sub9/link2";
		
	}
	
	@RequestMapping("link5")
	public String method5(Dto03 dto) {
		
	
		
		// 1. 쿼리 스트링 작성
		dto.setChamp("se");
		// 2. jsp 작성
		
		// dto의 property 출력
		return "/sub9/link3";
	}
		
		
}
