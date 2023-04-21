package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Products;
import com.example.demo.mapper.Mapper02;

@Controller
@RequestMapping("sub21")
public class Controller21 {
	@Autowired
	private Mapper02 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		/*
		String sql = """
				SELECT CustomerName FROM Customers
				""";
		*/
		List<String> list = mapper.sql1();
		/*
		List<String> list = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		*/
//		System.out.println(list);
		list.forEach(System.out::println);
	}
		@RequestMapping("link2")
		public void method2() {
			List<String> list2 = mapper.sql2();
			list2.forEach(System.out::println);
		}
		
		@RequestMapping("link3")
		public void method3() {
			List<String> names = mapper.sql2();
			names.forEach(System.out::println);
			
		}
		
		@RequestMapping("link4")
		public void method4() {
			List<Products> var = mapper.sql3();
			var.forEach(System.out::println);
		}
		
		
		@RequestMapping("link5")
		public void method5(@RequestParam("id") Integer cid) {
			List<Products> pr = mapper.sql4(cid);
		pr.forEach(System.out::println);
		}
		
		@RequestMapping("link6")
		public void method6(@RequestParam("city")String city) {
		List<Customer> ct = mapper.sql5(city);
		ct.forEach(System.out::println);
		}
}
