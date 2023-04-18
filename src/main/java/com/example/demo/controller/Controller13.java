package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;


@Controller
@RequestMapping("sub13")
public class Controller13 {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String name;

	@Value("${spring.datasource.password}")
	private String password;
	
	
	
	@RequestMapping("link1")
	public void method1(Model model) {
		String sql = """
				
				SELECT CustomerID, CustomerName,Address
				FROM Customers
				WHERE CustomerID < 4
				""";
		List<Customer> obj = new ArrayList<>();
		
		try(
				Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				){
		while(rs.next()) {
			int id = rs.getInt("CustomerID");
			String name = rs.getString("CustomerName");
			
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			obj.add(customer);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("C_List",obj);
			
		
	}
	
	
	@RequestMapping("link2")
	public void method2(Model model) {
		
		String sql = """
				SELECT EmployeeId,
				LastName,
				FirstName
				FROM Employees
				
				""";
		
		List<Employee> list = new ArrayList();
		
		try(
				Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				){
		while(rs.next()) {
			int id = rs.getInt("EmployeeID");
			String ln = rs.getString("LastName");
			String fn = rs.getString("FirstName");
			
			Employee employee = new Employee();
			employee.setId(id);
			employee.setLastName(ln);
			employee.setFirstName(fn);
			list.add(employee);
			
			model.addAttribute("employee",list);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		
	// 경로 : /sub13/link3?id=5
	@RequestMapping("link3")
	public String method3(@RequestParam String id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = """;
		sql += id;

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}

		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}	
	
	
	
	// 경로 : /sub13/link3?id=5
	@RequestMapping("link4")
	public String method4(@RequestParam String id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = ?""";
		sql += id;

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		stmt.setString(1, id);

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}

		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}
	
	// /sub13/link5?id=3
	@RequestMapping("link5")
	public String method5(@RequestParam String id,Model model) throws SQLException {
		
		//사용자에게 직원 id 입력 받아서
		// 쿼리 완성하고 실행 후에 
		// /sub13/link2 로 포워드 해서 직원 1명 출력
		var list = new ArrayList<Employee>();
		String sql = """
				SELECT EmployeeId,
				lastName,
				firstName
				FROM Employees
				WHERe EmployeeId = ?
				""";
		Connection con = DriverManager.getConnection(url,name,password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("employeeId"));
			employee.setFirstName(rs.getString("firstName"));
			employee.setLastName(rs.getString("lastName"));
			
			list.add(employee);
		}
		model.addAttribute("employeeList",list);
		return "/sub13/link2";
	}
	
}
