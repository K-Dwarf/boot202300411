package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Controller
@RequestMapping("sub11")
public class Controller11 {

	@Value("${spring.datasource.url}") // import org.springframework.beans.factory.annotation.Value;
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		// 2. business logic

		// 아이디가 '1' 인 고객이름 조회
		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;

		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";

		try (
				// db 연결
				Connection connection = DriverManager.getConnection(url, name, password);
				// statement 객체 생성
				Statement statement = connection.createStatement();
				// 쿼리실행

				// 쿼리 실행 결과 얻고
				ResultSet resultSet = statement.executeQuery(sql);) {
			// 쿼리 실행 결과 가공
			String name = "";
			if (resultSet.next()) {
				name = resultSet.getString("CustomerName");
			}

			// 3. add attribute
			model.addAttribute("customerName", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 4. forward
	}

	@RequestMapping("link2")
	public void method2(Model model1) {
		String employeeName = "";
		// * business logic
		// 아이디 3인 직원의 last name 조회

		String sql = "SELECT lastName FROM Employees WHERE EmployeeId = 3";
		try (
				// 1. 연결하기
				Connection con = DriverManager.getConnection(url, name, password);

				// 2. statement 생성
				Statement stmt = con.createStatement();
				// 3. 쿼리 실행 후 resultSet 얻기
				ResultSet rs = stmt.executeQuery(sql);) {
			// 4. resultSet 에 결과 있는지 확인하고
			if (rs.next()) {

				// 5. 결과 꺼내서 담기
				employeeName = rs.getString("lastName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(employeeName);
		// 6.try로 구문 감싸기

		// view 파일에서 출력할 attribute 생성
		model1.addAttribute("empname", employeeName);
	}

	@RequestMapping("link3")
	public void method3(Model model) {
		// * 업무
		// 아이디가 5인 상품 이름 조회
		String sql = """
				SELECT ProductName
				FROM Products
				WHERE ProductID = 5
				""";
		
		String productName = "";
		
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			try (con; stmt; rs;) {
				if (rs.next()) {
					productName = rs.getString("productName");
				}
			}
			
			System.out.println(productName);
			
			model.addAttribute("productName", productName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@RequestMapping("link4")
	public void method4(Model model) {
		// 업무
		// 고객 이름들 조회

		String sql = """
				SELECT CustomerName
				FROM Customers
				""";

		List<String> list = new ArrayList<>();

		try {

			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			try (con; stmt; rs;) {
				// list에 고객 이름들을 담고
				while (rs.next()) {
					list.add(rs.getString("CustomerName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. add attribute
		model.addAttribute("customerNames", list);
	}

	// 4.forward
}
