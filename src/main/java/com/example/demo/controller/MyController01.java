package com.example.demo.controller;
//method12 작성
	//1. request param 수집/가공
	// 2. business logic 
	// 3. add attribute
	// 4. forward,redirect

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class MyController01 {

	// 데이터 베이스 연동을 위한 값들을 보안을 위해 외부에 저장하고
	// 그 값들을 따로 가져옴
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("city")
	public void findcity(Model model) {

		String sql = """

				SELECT SupplierName
				From Suppliers
				WHERE City = 'Osaka'
						""";
		try (Connection connection = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = connection.prepareStatement(sql);
				) {

			ResultSet resultset = pstmt.executeQuery();
			String city = "";
			if (resultset.next()) {
				city = resultset.getString("SupplierName");

			}
			System.out.println(city);
			System.out.println(model);
			model.addAttribute("supname", city);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("customID")
	public void cuID(Model model) {
		String sql = """
				SELECT CustomerID,CustomerName 
				FROM Customers
				WHERE Country = 'USA'
				
				""";
		try(
				Connection connection = DriverManager.getConnection(url,name,password);
				Statement statement = connection.createStatement();
				ResultSet rst = statement.executeQuery(sql);
				){
		
		List<Map<String,Object>> idname = new ArrayList<>();
		while(rst.next()) {
			Map<String,Object> resultMap = new HashMap<>();
			String customId = rst.getString("CustomerID");
			String customName = rst.getString("CustomerName");
            
			resultMap.put("id", customId); // 추가
            resultMap.put("name", customName); // 추가
            idname.add(resultMap);

		}
		
		model.addAttribute("idname",idname);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void method2() {
		
		//1. request param 수집/가공
		// 2. business logic 
		// 3. add attribute
		// 4. forward,redirect

	}
	
	
	
	
}
