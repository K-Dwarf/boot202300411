package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Customer;

@Controller
@RequestMapping("sub14")
public class Controller14 {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	
	@RequestMapping("link1")
	public String method1(String keyword, Model model) {
		//String keyword 는 querystring으로 받을 파라미터
		String sql = """
				SELECT CustomerID,CustomerName,Address,ContactName
				FROM Customers
				WHERE CustomerName LIKE ?
				OR ContactName LIKE ?
				""";
		
		var list = new ArrayList<Customer>();
	try(
			Connection con = DriverManager.getConnection(url,name,password);
			PreparedStatement pstmt = con.prepareStatement(sql);
		){	
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			//첫번째 물음표에 "%" + keyword + "%" 를 집어넣음
			ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Customer c = new Customer();
			c.setId(rs.getInt("customerID"));
			c.setAddress(rs.getString("address"));
			c.setName(rs.getString("customerName"));
			c.setContactName(rs.getString("contactName"));
			list.add(c);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		model.addAttribute("customerList",list);
		return "/sub13/link1"; 
			
	}
}
