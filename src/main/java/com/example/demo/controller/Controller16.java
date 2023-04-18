package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("sub16")
public class Controller16 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	
	@RequestMapping("link1")
	public void method1(@RequestParam("id")int id) { // 여기서 reqparam을 어떻게 생략가능한지
		
		String sql = """
				
				DELETE FROM Suppliers
				WHERE SupplierID = ?
				""";
		try(
		Connection con = DriverManager.getConnection(url,name,password);
		PreparedStatement stm = con.prepareStatement(sql);
		){
		
		stm.setInt(1, id);
		stm.executeUpdate();
		System.out.println("삭제완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//고객 테이블의 데이터 삭제 메소드
	@RequestMapping("link2")
	public void method2(int id) { // 여기서 reqparam을 어떻게 생략가능한지
		
		String sql = """
				
				DELETE FROM Customers
				WHERE CustomerId = ?
				""";
		try(
		Connection con = DriverManager.getConnection(url,name,password);
		PreparedStatement stm = con.prepareStatement(sql);
		){
		
		stm.setInt(1, id);
		stm.executeUpdate();
		System.out.println("고객정보 소거완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
