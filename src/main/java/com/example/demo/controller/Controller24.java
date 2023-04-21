package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Customer;
import com.example.demo.mapper.Mapper05;

@Controller
@RequestMapping("sub24")
public class Controller24 {

	@Autowired
	private Mapper05 mapper05;
	
	@RequestMapping("link1")
	public void method1() {
		int cnt = mapper05.sql1();
	}
	
	@RequestMapping("link2")
	public void method2() {
		mapper05.sql2(123,"mybatis",315);
	}
	
	@RequestMapping("link3")
	public void method3() {
		//10번 고객 이름과 국가가 변경되도록
		//mapper 에 sql 메소드 작성
		int cnt = mapper05.sql3(10,"새로운 고객명","대한민국");
		System.out.println(cnt + "번 고객 업데이트");	
	}
	
	@RequestMapping("link4")
	public void method4() {
		Customer customer = new Customer();
		customer.setCustomerId(5);
		customer.setCity("mokpo");
		customer.setAddress("sinhan");
		customer.setContactName("gam");
		customer.setCustomerName("zeratul");
		customer.setPostalCode("3241");
		customer.setCountry("prop");
		
		int count = mapper05.sql4(customer);
		System.out.println(count);
	}
	// ******************** ******************** ********************
	@RequestMapping("link5")
	public void method5(@ModelAttribute Customer customer) {
		int count = mapper05.sql4(customer);
		System.out.println(count + "명의 고객 변경");
	}
	// /sub24/link6?id=9
	@RequestMapping("link6")
	public void method6(Integer id,Model model) {
		Customer customer = mapper05.sql5(id);
		model.addAttribute("customer",customer);
	}
	// *************************************************************
	// 클라이언트에서 파라미터값+요청 -> 컨트롤러 link6 -> view link6 ->
	// 컨트롤러 link5 -> mapper sql4 -> DB업데이트 
	//******************** ******************** ********************
}
