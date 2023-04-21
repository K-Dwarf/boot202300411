package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Dto06;
import com.example.demo.domain.Employees;
import com.example.demo.domain.Products;
import com.example.demo.domain.Supplier;
import com.example.demo.mapper.Mapper01;

@Controller
@RequestMapping("sub20")
public class Controller20mybatis {

	
	@Autowired
	private Mapper01 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		String name = mapper.method1();
		System.out.println(name);
				
	}
		
	@RequestMapping("link2")
	public void method2() {
		String Fname = mapper.method2();
		System.out.println(Fname);
	
	}
	
	@RequestMapping("link3")
	public void method3() {
		String sup = mapper.method3();
		System.out.println(sup);
	}
	
	@RequestMapping("link4")
	public void method4(@RequestParam("id") Integer customerId)	{
		String name = mapper.method4(customerId);
		System.out.println(name);
		}
	
	
	@RequestMapping("link5")
	public void method5(@RequestParam("id") Integer eid)	{
		String name = mapper.method5(eid);
		System.out.println(name);
		}
	
	
	@RequestMapping("link6")
	public void method6() {
		Integer price = mapper.method6();
		System.out.println(price);
	}
	
	
	@RequestMapping("link7")
	public void method7() {
		Dto06 res = mapper.method10();
		System.out.println(res);
	}
	
	
	@RequestMapping("link9")
	public void method9() {
		Customer cus = mapper.method12();
		System.out.println(cus);
	}
	
	@RequestMapping("link10")
	public void method10() {
		Supplier sup = mapper.method13();
		System.out.println(sup);
	}
	
	
	@RequestMapping("link11")
	public void method11() {
		Employees em = mapper.method14();
		System.out.println(em);
	}
	
	@RequestMapping("link12")
	public void method12() {
		Products pd = mapper.method15();
		System.out.println(pd);
	}
	
	// 클라이언트에서 ID값 받아서 해당 컬럼의 값 도출하기 
	
	@RequestMapping("link13")
	public void method13(@RequestParam Integer id) {
		List<Products> productsList = mapper.method16(id);
		System.out.println(productsList);
		
	}
	
	
}

