package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Employees;

@Controller
@RequestMapping("sub3")
public class MyController03 {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	
	@RequestMapping("link1")
		public String method1(Model model) {
			List<String> list = new ArrayList<>();
			String a = "";
		String sql = """
				SELECT EmployeeID,
				LastName,
				FirstName
				FROM Employees
				WHERE EmployeeID = 1 OR EmployeeID = 2
				
				""";
		try(
		Connection con = DriverManager.getConnection(url,name,password);
		Statement pst = con.createStatement();
		ResultSet rs = pst.executeQuery(sql);
				){
		
		while(rs.next()) {
			 a = rs.getString("LastName");
			 list.add(a);
		}
		System.out.println(list);
		
		}catch(Exception e) {
			e.printStackTrace();
		}model.addAttribute("em",list);
		return "/sub13/link3";
	}
	
}
