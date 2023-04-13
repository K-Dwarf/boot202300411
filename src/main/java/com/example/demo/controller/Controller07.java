package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dto01;
import com.example.demo.domain.Dto02;
import com.example.demo.domain.Dto04;
import com.example.demo.domain.ProblemCase;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub07")
public class Controller07 {
	
	@RequestMapping("link1")
	public void method01(HttpServletRequest req) {
		//1.
		//2.
		//3. add attribute
		
		req.setAttribute("myName", "서태웅");
		
		//4. /WEB-INf/views/sub7/link1.jsp 로 포워드
		
	}

	
	@RequestMapping("link2")
	public String method2(Model model) {
		
		
		//3. add attribute
		model.addAttribute("myName","zeratul");
		
		return "/sub07/link1";
		
	}
	
	@RequestMapping("link3")
	public String method3(Model model2) {

		model2.addAttribute("myFamilly","15");
		
		return "/sub07/link2";  //따로 지정하지 않으면 /sub07/link3 으로 들어감
	}
	
	
	@RequestMapping("link4")
	public String method4(Model mode3, @RequestParam String name , @RequestParam int age) {
	    
		System.out.println("link4 실행되고  sub07/link1로 forward함");
		
	    //3. add attribute
	    mode3.addAttribute("myName", name);
	    mode3.addAttribute("age",age);
	    
	    
	    return "/sub07/link1";
	}

	@RequestMapping("link5")
	public String method05(Model model) {
		model.addAttribute("list",List.of("java","spring","jsp"));
		
		return "/sub07/link3";
	}
	
	
	@RequestMapping("link6")
	public String method06(Model model) {
		Map<String,String> map = new HashMap<>();
		map.put("name", "kim");
		map.put("age", "15");
		model.addAttribute("myMap",map);
		
		return "/sub07/link4";
	}
	
	
	
	@RequestMapping("link7")
	public String method07(Model model) {
		model.addAttribute("age",50);
		model.addAttribute("country","korea");
		model.addAttribute("movie",List.of("ironman","batman","superman","spiderman"));
		
		return "/sub07/link5";
	}
		
	//java Bean 활용 /domain/Dto01.java 를 가져와서 활용함
	@RequestMapping("link8")
	public String method08(Model model) {
		Dto01 o1 = new Dto01();
		o1.setName("park");
		o1.setAge(14);
		
		
		model.addAttribute("player",o1);
		
		return "/sub07/link6";
	}
	
	@RequestMapping("link9")
	public String method09(Model model2) {
		Dto02 o2 = new Dto02();
		o2.setCompany("joonganng");
		o2.setModel("Baeck");
		o2.setPrice(900000);
		
		model2.addAttribute("value",o2);
		
		return "/sub07/link9";
	}
		
	@RequestMapping("link10")
	public String method10(Model model3) {
		Dto04 o4 = new Dto04();
		o4.setName("zeratul");
		o4.setAge(1998);
		
		model3.addAttribute("val",o4);
		return "/sub07/link10";
		
	}
	
	

}
