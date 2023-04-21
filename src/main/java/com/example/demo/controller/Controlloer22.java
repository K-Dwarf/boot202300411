package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Dto09;
import com.example.demo.domain.Dto10;
import com.example.demo.domain.Dto11;
import com.example.demo.domain.Dto12;
import com.example.demo.domain.Employees;
import com.example.demo.mapper.Mapper02;

@Controller
@RequestMapping("sub22")
public class Controlloer22 {

	@Autowired
	private Mapper02 mapper;
	
	
	
	
	@RequestMapping("link1")
	public void method4() {
		Dto09 dto = new Dto09();
		dto.setProp1(3700);
		dto.setProp2("burning friday");
		dto.setProp3(3.14);
		
		int cnt = mapper.sql7(dto);
	}
	
	@RequestMapping("link2")
	public void method5(
			@RequestParam Integer prop1,
			@RequestParam String prop2,
			@RequestParam Double prop3) {
		 Dto09 dto = new Dto09();
		    dto.setProp1(prop1);
		    dto.setProp2(prop2);
		    dto.setProp3(prop3);
		    
		    int cnt = mapper.sql7(dto);
	        System.out.println(cnt + "개 행 입력완료");
	}
	
	@RequestMapping("link8")
	public void method8() {
		Dto09 dto1 = new Dto09();
		Employees dto2 = new Employees();
		dto1.setProp1(25);
		dto1.setProp2("laze");
		dto2.setId(50);
		mapper.sql9(dto1, dto2);
	}
	
	@RequestMapping("link9")
	public void method9() {
		Dto09 o1 = new Dto09();
		Dto10 o2 = new Dto10();
		
		o1.setProp1(123);
		o1.setProp2("14");
		
	}
	@RequestMapping("link10")
	@ResponseBody
	public void method10(@RequestParam Dto09 p1, Dto10 p2) {
	mapper.sql6(p1, p2);
	System.out.println();
	}
	
	@RequestMapping("link11")
	public String method11(Dto11 dto) {
		System.out.println("prop1:" + dto.getProp1());
		int cnt = mapper.sql11(dto);
		System.out.println(cnt + "행 입력완료");
		System.out.println("prop1:"+ dto.getProp1());
		
		return dto.getProp1() + "data";
	}
	
	// /sub22/link12?age=40&name=son&score=9.9
	// 요청시 MyTable40에 데이터 추가되도록 코드
	// 컨트롤러,맵퍼(DAO),JavaBean(DTO)
	// 자바빈의 id 프로퍼티에 자동증가 컬럼값 받을 수 있게
	
	@RequestMapping("link12")
	public int method12(Dto12 dto) {
		
		mapper.sql12(dto);
		return dto.getId();
		}
	
	
}
