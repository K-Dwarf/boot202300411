package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Supplier;

@Controller
@RequestMapping("sub17")
public class Controller17 {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	// ?id=65&name=zeratul
	@RequestMapping("link1")
	public void method1(int id, String name) {
		String sql = """
				
				UPDATE Suppliers
				SET 
					SupplierName = ?
				WHERE SupplierID = ?
				
				""";
		try(
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement stm = con.prepareStatement(sql);
				){
		
		stm.setString(1, name);
		stm.setInt(2, id);
		
		int cnt = stm.executeUpdate();
		System.out.println(cnt + "개의 행 수정됨");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// supplierid 가 ?번인 공급자 주소(address)를 seoul 로 바꾸는 메소드
	// sub17/link2/?address=seoul
	@RequestMapping("link2")
	public void method2(String address, int id) {
		System.out.println("시작은함");
		String sql = """
				
				UPDATE Suppliers
				SET 
				Address = ?
				WHERE SupplierID = ?
				""";
				
		try(
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = con.prepareStatement(sql);
				){
		
		ps.setString(1, address);
		ps.setInt(2, id);
		int update_num = ps.executeUpdate();
		System.out.println(update_num + "개의 행 변경");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("link3")
	public void method3(Supplier supplier) {
		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?,
					ContactName = ?,
					Address = ?,
					City = ?,
					PostalCode = ?,
					Country = ?,
					Phone = ?
				WHERE 
				SupplierId = ?
				""";
		
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, supplier.getSupplierName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
			pstmt.setInt(8, supplier.getId());
			
			int num_of_change = pstmt.executeUpdate();
			System.out.println(num_of_change);
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
		
		
	@RequestMapping("link4")
	public void method4(int id, Model model) {
		String sql = """
				
				SELECT 
					SupplierName,
					ContactName,
					Address,
					City,
					PostalCode,
					Country,
					Phone
				FROM Suppliers
				WHERE SupplierId = ?
				
				""";
		try(
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pst = con.prepareStatement(sql);
				){
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setId(rs.getInt("supplierId"));
			supplier.setSupplierName(rs.getString("supplierName"));
			supplier.setContactName(rs.getString("contactName"));
			supplier.setAddress(rs.getString("address"));
			supplier.setCity(rs.getString("city"));
			supplier.setPostalCode(rs.getString("postalCode"));
			supplier.setCountry(rs.getString("country"));
			supplier.setPhone(rs.getString("phone"));
			model.addAttribute("supplier", supplier);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//고객조회 method4참고
	// Customer JavaBean, link5.jsp 필요
	@RequestMapping("link5")
	public void method5(int id, Model model) {
		String sql = """
				
				SELECT
				CustomerID,
				CustomerName,
				ContactName,
				Address,
				City,
				PostalCode,
				Country
				FROM Customers
				WHERE CustomerID = ?
				
				""";
		
		try(
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pst = con.prepareStatement(sql);// sql실행을 위한 객체 생성(sql실행값아님)
				){
		
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		// ResultSet은 데이터베이스 쿼리 실행 결과로 반환된 테이블을 나타내는 자바 인터페이스입니다.
		// pst.executeQuery() 메서드는 쿼리문을 실행하고 ResultSet 객체를 반환
		
		if(rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerName(rs.getString("customerName"));
			customer.setContactName(rs.getString("contactName"));
			customer.setAddress(rs.getString("address"));
			customer.setCity(rs.getString("city"));
			customer.setPostalCode(rs.getString("postalCode"));
			customer.setCountry(rs.getString("country"));
			customer.setCustomerId(rs.getInt("customerID"));
			model.addAttribute("customer", customer);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("link6")
	public void method6(Customer customer) { //form 태그 안의 name 속성값과 일치하는 
		//Customer 클래스를 도메인에서 찾아 해당 클래스의 프로퍼티에 값을 바인딩
		String sql = """
				UPDATE Customers
				SET
					CustomerName = ?,
					ContactName = ?,
					Address = ?,
					City = ?,
					PostalCode = ?,
					Country = ?
					
				WHERE 
				CustomerID = ?
				""";
		
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());
			pstmt.setString(4, customer.getCity());
			pstmt.setString(5, customer.getPostalCode());
			pstmt.setString(6, customer.getCountry());
			pstmt.setInt(7, customer.getCustomerId());
									
			int num_of_change = pstmt.executeUpdate();
			System.out.println(num_of_change);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}