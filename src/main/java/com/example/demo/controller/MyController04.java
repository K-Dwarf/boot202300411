package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Products;

@Controller
@RequestMapping("mysub")
public class MyController04 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	

	@RequestMapping("product")
	public void method10(int id,Model model) {
		
		String sql = """
				SELECT ProductID,
				ProductName,
				SupplierID,
				CategoryID,
				Unit,
				Price
			FROM Products
			WHERE ProductID= ?
							
				""";
		
		try(
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pst = con.prepareStatement(sql);
				){
		
		
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			Products products = new Products();
			products.setProductId(rs.getInt("productID"));
			products.setProductName(rs.getString("ProductName"));
			products.setSupplierId(rs.getInt("supplierID"));
			products.setCategoryId(rs.getInt("CategoryID"));
			products.setUnit(rs.getString("Unit"));
			products.setPrice(rs.getDouble("price"));
			
			//setPrice는 도메인의 생성자set에서 rs.get은 DB의colum에서 가져옴
			
			model.addAttribute("products",products);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
		
		
		
	@RequestMapping("product2")
	public void method02(Products product) {
		String sql = """
				UPDATE Products
				SET
					ProductName = ?,
					SupplierID = ?,
					CategoryID = ?,
					Unit = ?,
					Price = ?
					
					
				WHERE 
				ProductID = ?
				""";
		
		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement stm = con.prepareStatement(sql);) {
			stm.setString(1, product.getProductName());
			stm.setInt(2, product.getSupplierId());
			stm.setInt(3, product.getCategoryId());
			stm.setString(4, product.getUnit());
			stm.setDouble(5, product.getPrice());
			stm.setInt(6, product.getProductId());
			
									
			int num_of_change = stm.executeUpdate();
			System.out.println(num_of_change);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
}
