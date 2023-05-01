package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Employees;
import com.example.demo.mapper.Mapper07;

@Controller
@RequestMapping("sub27")
public class Controller27 {

	
	@Autowired
	private Mapper07 mapper;
	
	
	// 경로 : /sub27/link1?s=ell
	@GetMapping("link1")
	public String method1(Model model ,@RequestParam(value="s",defaultValue="")String key) {
		mapper.sql1(key);
		
		model.addAttribute("customerList",mapper.sql1(key));
		
		return "/sub13/link1";
		
	}
	
	// 경로: /sub27link2?search=eve   로 요청보내면 lastname혹은 firstname 에 eve가 포함된 직원 호출
	@GetMapping("link2")
	public String method2(Model model,@RequestParam(value="search",defaultValue="")String emfind) {
		
		mapper.sql2(emfind);
		
		emfind = "%" + emfind + "%";
		List<Employees> list = mapper.sql2(emfind);
		model.addAttribute("employee",list);
		
		return "/sub13/link2"; // 직원 lastName, firstName 
		
	}
	
	
	@GetMapping("link3")
	public void method3() {
		mapper.sql3();
		
	}
	
	@GetMapping("link4")
	public void method4() {
		mapper.sql4("eve");
	}
	
	@GetMapping("link5")
	public void method5() {
		mapper.sql4("null");
	}
	

	@GetMapping("link6")
	public String mehtod6(Model model) {
		// 3번 카테고리 상품의 평균 가격
		Double avg = mapper.sql5(3);
		model.addAttribute("avg",avg);
		return "sub25/link6";
	}
	// /sub27/link7?dg=5
	@GetMapping("link7")
	public String method7(@RequestParam("dg") int p, Model model) {
		//모든 상품의 평균 가격
		Double avg = mapper.sql5(p);
		
		model.addAttribute("emp",avg);
		
		return "sub25/link6";
	}
	
}
