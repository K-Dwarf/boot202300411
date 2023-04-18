package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mysub")
public class MyController02 {
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String name;
	
	@Value("${spring.datasource.password}")
	private String password;
	

	@RequestMapping("customerName")
	public void method1(Model customerName) {
		
		String sql ="""
				SELECT CustomerName,
				CustomerID
				 FROM Customers
				 WHERE City ='Seoul';
							
				""";
	try(
			
			Connection con = DriverManager.getConnection(url,name,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			){	
		List<Map<String,Object>> IdName = new ArrayList<>();
		List<String> list = new ArrayList<>();
		while (rs.next()) {
			// ID와 Name을 따로 구분해서 출력할 수 있게 하려고 HashMap활용
			Map<String,Object> resultMap = new HashMap<>();
			String C_Name = (rs.getString("CustomerName"));
			String C_ID =(rs.getString("CustomerID"));
			
			list.add(C_Name);
			list.add(C_ID);
			
			resultMap.put("ID", C_ID);
			resultMap.put("name", C_Name);
			IdName.add(resultMap);
			
		}
		customerName.addAttribute("IdName",IdName);
		customerName.addAttribute("customerName",list);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
		
	
	
	
}
