package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Shippers;
import com.example.demo.mapper.Mymapper01;

@Controller
@RequestMapping("mysub")
public class MyController05 {
	
	@Autowired
	private Mymapper01 mymap;
	
	
	// /mysub/shipper
	@RequestMapping("shipper")
	public void insertshipper() {
		Shippers shipper = new Shippers();
		shipper.setPhone("010-2960");
		shipper.setShipperName("JIM");
		
		mymap.mysql01(shipper);
		
	}
	
	@RequestMapping("shipper2")
	public void inertshipper2(Shippers shipper) {
		int count = mymap.Mysql02(shipper);
		System.out.println(count + "개의 변경");
	}
	
	@RequestMapping("shipper3")
	public void insertshipper3(int id,Model model) {
		
		
	}
	

}
