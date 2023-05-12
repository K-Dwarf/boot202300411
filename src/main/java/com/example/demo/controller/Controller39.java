package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Products;
import com.example.demo.mapper.Mapper02;

@Controller
@RequestMapping("sub39")
public class Controller39 {

	
	@RequestMapping("view")
	public void view() {
		
	}
	
	
	@GetMapping("link1")
	@ResponseBody
	public String method1() {
		return "hello ajax";
	}



	@GetMapping("link2")
	@ResponseBody
	public ResponseEntity method2() {
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("link3")
	@ResponseBody
	public ResponseEntity method3() {
		
		return ResponseEntity.ok().build();
	}

	@GetMapping("link4")
	@ResponseBody
	public ResponseEntity method4() {
		
		return ResponseEntity.badRequest().build();
	}
	
	/*
	@GetMapping("link5")
	public ResponseEntity method5() {
		boolean ok = service.method();
		if(ok) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
			
	}*/


	@GetMapping("link9")
	@ResponseBody
	public String method9() {
		return "hello ajax!@!@!@";
	}
	
	@GetMapping("link10")
	@ResponseBody
	public LocalDateTime method10() {
		LocalDateTime now = LocalDateTime.now();
		return now;
	}
	
	@GetMapping("link11")
	@ResponseBody
	public Map<String,Object>method11(){
		return Map.of("name","zeratul","age",21);
	}
	
	
	@GetMapping("link12")
	@ResponseBody
	public Map<String,Object>Method12(){ //Map<String,Object> 형식으로 작성하면 JSON형식이랑 같음
		
		return Map.of("address","Seoul","city","korea","phone","010-2960-6228");
		
	}

	@GetMapping("link13")
	@ResponseBody
	public List<String> method13(){
		return List.of("강시","영대","수빈");
		
	}
	
	@Autowired
	private Mapper02 mapper02;
	
	@GetMapping("link14")
	@ResponseBody
	public List<Products> method21(Integer cid) {
		return mapper02.sql4(cid);
	}
}




