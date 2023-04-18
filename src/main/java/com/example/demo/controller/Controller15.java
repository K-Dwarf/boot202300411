package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Supplier;

@Controller
@RequestMapping("sub15")
public class Controller15 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	// sub15/link3?customerName=zera&city=tearran&country=korea
	@RequestMapping("link3")
	public void method3(@RequestParam("customerName") String customerName, @RequestParam("city") String city,
			@RequestParam("country") String country) {
		String sql = """

				INSERT INTO Customers
				(CustomerName, City,Country)
				VALUES
				(?,?,?)
				""";
		try (Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement stm = con.prepareStatement(sql);) {

			stm.setString(1, customerName);
			stm.setString(2, city);
			stm.setString(3, country);

			int count = stm.executeUpdate();
			System.out.println(count + "개 행 추가됨");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link4")
	public void method4(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {

		String sql = """

				INSERT INTO Employees
				(firstName,lastName)
				VALUES
				(?,?)
				""";
		try (Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement smt = con.prepareStatement(sql);

		) {
			smt.setString(1, firstName);
			smt.setString(2, lastName);
			int count = smt.executeUpdate();
			System.out.println(count + "개 행 추가됨");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link5")
	public void method5() {
		// form 이 있는 view 로 포워드
		// view : /WEB-INF/view/sub15/link5.jsp
	}

	@RequestMapping("link6")
	public void method6(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName
			) {
		System.out.println(firstName);
		System.out.println(lastName);

		String sql = """
				INSERT INTO Employees (firstName,lastName)
				VALUES(?,?)
				""";
		try (
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement stm = con.prepareStatement(sql);

		) {

			stm.setString(1, firstName);
			stm.setString(2, lastName);
			stm.executeUpdate(); // 업데이트 해주어야 DB로 넘김(INSERT,UPDATE,DELETE)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("link7")
	public void method07() {
		
	}
	
	@RequestMapping("link8")
	public void method8(
			@RequestParam("name")String name,
			@RequestParam("city")String city,
			@RequestParam("country")String country
			) {

		String sql = """
				INSERT INTO Suppliers (SupplierName,City,Country)
				VALUES(?,?,?)
				
				""";
		
		try(
		Connection con = DriverManager.getConnection(url,this.name,password);
		PreparedStatement stm = con.prepareStatement(sql);
				){
			stm.setString(1,name);
			stm.setString(2, city);
			stm.setString(3, country);
			
			stm.executeUpdate(); 
			System.out.println(stm);
			System.out.println("실행됨");
		}catch(Exception e) {
		e.printStackTrace();
		}
		
}
	
	@RequestMapping("link9")
	public void method9() {

	}
	
	@RequestMapping("link10")//@ModelAttribute로 같은 이름의 javaBeam 객체를 가져옴(@modelattribute생략가능)
	//public void method10(@ModelAttribute("customer")Customer customer) 
	public void method10(Customer customer){
		String sql = """
				
				INSERT INTO Customers
				(CustomerName,ContactName,Address)
				VALUES
				(?,?,?)
				
				""";
		try(
		Connection con = DriverManager.getConnection(url,name,password);
		PreparedStatement smt = con.prepareStatement(sql);
				){
		
		
		smt.setString(1,customer.getCustomerName());
		smt.setString(2,customer.getContactName());
		smt.setString(3,customer.getAddress());
		smt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	
	@RequestMapping("link11")
	public void method() {
		
	}

	
	@RequestMapping("link12")
	public void method(Supplier supplier) {
		String sql = """
				
				INSERT INTO Suppliers
				(SupplierName,
				ContactName,
				Address,
				City,
				PostalCode,
				Country,
				Phone)
				VALUES(?,?,?,?,?,?,?)
				""";
		try(
		Connection con = DriverManager.getConnection(url,name,password);
		PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				){
		
			stm.setString(1, supplier.getSupplierName());
		stm.setString(2, supplier.getContactName());
		stm.setString(3, supplier.getAddress());
		stm.setString(4, supplier.getCity());
		stm.setString(5, supplier.getPostalCode());
		stm.setString(6, supplier.getCountry());
		stm.setString(7, supplier.getPhone());
		stm.executeUpdate();
		
		// 자동생성된 컬럼(키) 값 얻기
		ResultSet key = stm.getGeneratedKeys();
		
		int keyValue = 0;
		if (key.next()) {
			keyValue = key.getInt(1);
		}
		System.out.println(keyValue + "번째 데이터 입력됨");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
