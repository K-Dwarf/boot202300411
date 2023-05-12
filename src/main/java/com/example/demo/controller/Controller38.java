package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Products;
import com.example.demo.mapper.Mapper02;

@Controller
@RequestMapping("sub38")
public class Controller38 {

	@Autowired
	Mapper02 mapper02;
	
	@GetMapping("link20")
	@ResponseBody
	public List<String> method20() {
		return mapper02.sql1();
	}
	@GetMapping("link21")
	@ResponseBody
	public List<Products> method21() {
		return mapper02.sql3();
	}
	
	@GetMapping("link22")
	@ResponseBody
	public List<Products> method22(Integer cid) {
		return mapper02.sql4(cid);
	}
	
}