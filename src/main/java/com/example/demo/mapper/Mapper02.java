package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Dto09;
import com.example.demo.domain.Dto10;
import com.example.demo.domain.Dto11;
import com.example.demo.domain.Dto12;
import com.example.demo.domain.Employees;
import com.example.demo.domain.Products;

@Mapper
public interface Mapper02 {
	
	
	@Select("""
			SELECT CustomerName FROM Customers
			""")
	
	List<String>sql1();
	
	
	
	@Select("""
			SELECT LastName
			FROM Employees
			
			""")

	List<String>sql2();
	
	@Select("""
			SELECT LastName,FirstName
			FROM Employees
			""")
	List<Employees> method1(Integer pas);
	
	
	@Select("""
			SELECT Price,ProductName
			FROM Products
			""")
	List<Products> sql3();
	
	
	@Select("""
			SELECT ProductName
			FROM Products
			WHERE CategoryID = #{id}
			""")
	List<Products> sql4(Integer cid);
	
	
	@Select("""
			SELECT CustomerName,contactName,postalCode
			FROM Customers
			WHERE City = #{city}
			""")
	List<Customer> sql5(String city);
	
	
	 @Insert("""
	            INSERT INTO MyTable36 (col1, col2, col3)
	            VALUES (#{prop1}, #{prop2}, #{prop3})
	            """)
	    int sql7(Dto09 dto);
	
	
	@Insert("""
			INSERT INTO MyTable36 (col1,col2,col3)
			VALUES (#{prop1},#{prop2},#{prop3})
			""")
	int sql8(Dto09 dto);

	@Insert("""
			INSERT INTO MyTable37 (Age,Name,Score)
			VALUES(#{dto9.prop1},#{dto9.prop2},#{dto10.EmployeeID})
			
			""")
int sql9(Dto09 dto9, Employees dto10);
	
	
	@Insert("""
			INSERT INTO MyTable38(Col1,Col2,Col3,Col4,Col5,Col6)
			VALUES(
			#{dto1.prop1},
			#{dto2.age},
			#{dto1.prop2},
			#{dto2.name},
			#{dto2.score})
			""")
	int sql6(Dto09 dto1, Dto10 dto2);


	@Insert("""
			INSERT INTO MyTable39 (Col2,Col3)
			VALUES(#{prop2},#{prop3}
			""")
	@Options(useGeneratedKeys = true,keyProperty = "")
	int sql11(Dto11 dto);
	
	
	
	@Insert("""
			INSERT INTO MyTable40(
			
			Age,
			Name,
			Score)
			VALUES(#{age},#{name},#{score})
			""")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int sql12(Dto12 dto);
}
