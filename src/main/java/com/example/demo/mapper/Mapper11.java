package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Category;
import com.example.demo.domain.Supplier;

@Mapper
public interface Mapper11 {

	
	@Select("""
			SELECT
			c.CategoryId, 
			c.CategoryName,
			c.Description,
			p.ProductName,
			p.Price
			FROM Categories c JOIN Products p
			ON c.CategoryId = p.CategoryId
			WHERe c.CategoryId = #{id} 
			
			""")
	
	@ResultMap("categoryResult")
	Category sql1(int id);
		
	
	@Select("""
			SELECT
			c.CategoryId,
			c.CategoryName,
			c.Description,
			p.ProductName,
			p.Price
			FROM Categories c JOIN Products p 
			ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryResultMap")
	Category sql2(int id);
	
	
	@Select("""
			SELECT
			s.SupplierID,
			s.City,
			s.ContactName,
			s.SupplierName,
			p.ProductName,
			p.ProductID
			FROM Suppliers s JOIN Products p
			ON s.SupplierID = p.SupplierID
            WHERE s.SupplierID = #{id}
			
			""")
	@ResultMap("SupplierMap")
	Supplier sql3(int id);
}
