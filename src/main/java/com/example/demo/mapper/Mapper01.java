package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Dto06;
import com.example.demo.domain.Employees;
import com.example.demo.domain.Products;
import com.example.demo.domain.Supplier;

@Mapper
public interface Mapper01 {
	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = 1
			""")
	String method1();
	
	
	@Select("""
			SELECT FirstName
			FROM Employees
			WHERE EmployeeID = 1
			
			""")
	String method2();
	
	
	
	@Select("""
			SELECT SupplierName
			FROM Suppliers
			WHERE SupplierID = 3
			""")
	String method3();

	@Select("""
			SELECT CustomerName
			FROM Customers

			WHERE CustomerID = #{id}
					
			""")
	String method4(Integer id);
	
	
	
	@Select("""
			
			SELECT LastName
			FROM Employees
			WHERE EmployeeId = #{id}
			"""	)
	String method5(Integer id);
	
	
	@Select("""
			SELECT Price
			FROM MyTable33
			WHERE 
			""")
		int method6();

	
	
	@Select("""
			SELECT Title,
			Published,
			Price,
			Updated,
			Weight
			FROM MyTable33
			LIMIT 1
			
			""")
	
	// 컬럼명과 (대소문자 구분 없이) 매치되는 빈의 프로퍼티명
	Dto06 method10();
	
	
	@Select("""
			SELECT 
			CustomerId,
			CustomerName,
			ContactName,
			Address,
			City,
			PostalCode,
			Country
			FROM Customers
			WHERE CustomerID = 7
			""")
	Customer method12(); //받아온 객체의 프로퍼티와 컬럼명이 일치해야함
	
	
	@Select("""
			SELECT
			SupplierID,
			SupplierName,
			ContactName,
			Address,
			City,
			postalCode,
			Country,
			Phone
			FROM Suppliers
			WHERE SupplierID = 3
			""")
	
	Supplier method13();

	
	@Select("""
			SELECT
			EmployeeID,
			LastName,
			FirstName,
			BirthDate,
			Photo,
			Notes
			FROM Employees
			WHERE EmployeeID = 5
			""")

	Employees method14();
	
	@Select("""
			SELECT 
			ProductID,
			ProductName,
			SupplierID,
			CategoryID,
			Unit,
			Price
			FROM Products
			WHERE ProductID = 2
			""")
	Products method15();
	
	
	
	@Select("""
			SELECT
			ProductID,
			ProductName,
			SupplierID,
			CategoryID,
			Unit,
			Price
			FROM Products
			WHERE categoryID = #{id}
			
			""")
	List<Products> method16(Integer id);
	// WHERE categoryID = #{id} 해당 ID 에 해당하는
	// 모든 컬럼을 가져오기때문에 List화 할 필요가 있음
}
	

