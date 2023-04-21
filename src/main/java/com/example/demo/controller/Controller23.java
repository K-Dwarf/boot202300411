package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dto12;
import com.example.demo.mapper.Mapper04;

@Controller
@RequestMapping("sub23")
public class Controller23 {

	
	@Autowired
	private Mapper04 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		mapper.sql1();
	}
	
	// sub23/link2?id=3
	@RequestMapping("link2")
	public void method2(Integer id) {
		int cnt = mapper.sql2(id);
		System.out.println();
	}
	
	//sub23/link3?key=7
	@RequestMapping("link3")
		public void method3(Integer id) {
			int cnt = mapper.sql3(id);
			System.out.println(cnt + "번 고객 삭제");
		}
		// 메소드 만들기
		//7번고객 삭제하기
	@RequestMapping("link99")
	public void method99(Integer key) {
		int num = mapper.sql99(key);
		System.out.println(num + "번 고객 삭제");
		
		
	}
		
	
}


