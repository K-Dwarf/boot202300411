package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;

@Controller
@RequestMapping("sub35")
public class Controller35 {

	
		@GetMapping("ajax1")
		public void view() {
		}
		
		@PostMapping("link1")
		public void method1() {
			System.out.println("post requset  받음");
		}
			
		
		@PostMapping("link2")
		public void method2() {
			System.out.println("post 요청받아서 method2실행");
		}
		
		
		@PostMapping("link3")
		public void method3(@RequestParam("name") String name) {
			System.out.println("name = " + name);
		}
		
		@PostMapping("link4")
		public void method4(String address, Double price) {
			System.out.println("address = " + address);
			System.out.println(price);
		}
		
		@Data
		static class Dto1 {
			private String name;
			private Double score;
			private String email;
		}
		@PostMapping("link5")
		public void method5(Dto1 dto) {
			System.out.println(dto);
		}
		
		@Data
		static class Dto2 {
			private String address;
			private String product;
			private	Double price;
		}
		@PostMapping("link6")
		public void method6(Dto2 dto) {
			System.out.println(dto);
		}
		
		
		
		
		// json 요청 데이터는
		// @RequestBody Map 이나
		// @RequestBody JavaBean 으로 받음
		@PostMapping("link7")
		public void method7(@RequestBody Map map) {
			System.out.println("link7메소드실행");
			System.out.println(map);
		}
		
		
		@PostMapping("link8")
		public void method8(@RequestBody Map data) {
			System.out.println(data.get("address"));
		}
		
		
		// {"age": "33", "name": "cha", "married": "true"}
		@PostMapping("link9")
		public void method9(@RequestBody Map data) {
			System.out.println(data.get("age"));
			System.out.println(data.get("name"));
			System.out.println(data.get("married"));
			
			System.out.println(data.get("age").getClass().getSimpleName());
			System.out.println(data.get("name").getClass().getSimpleName());
			System.out.println(data.get("married").getClass().getSimpleName());
		}
		
		@PostMapping("link10")
		public void method10(@RequestBody Map<String, Object> map) {
			System.out.println(map);
		}
		
		@PostMapping("link11")
		public void method11(@RequestBody Map<String, Object> map) {
			System.out.println(map);
			System.out.println(map.get("book"));
			System.out.println(map.get("book").getClass().getSimpleName());
			
			Map<String, Object> book = (Map<String, Object>) map.get("book");
			System.out.println(book.get("title"));
			System.out.println(book.get("price"));
		}
		
		@PostMapping("link12")
		public void method12(@RequestBody Map<String, Object> map) {
			System.out.println(map);
			System.out.println(map.get("food").getClass().getSimpleName());
			
			ArrayList<Object> foods = (ArrayList<Object>) map.get("food");
			System.out.println(foods.get(0));
			System.out.println(foods.get(1));
			System.out.println(foods.get(2));
		}
		// ["pizza", "coke", "coffee"]
		@PostMapping("link13")
		public void method13(@RequestBody Map<String, Object> data) {
			System.out.println(data);
		}
		
		// `[{"name":"zeratul","pos":"deal"},{"name":"jim","pos":"defence"},{}]`
		@PostMapping("link14")

		public void method14(@RequestBody List<Map<String, Object>> data) {
			System.out.println(data);

		}
	}

