package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employees;

@Mapper
public interface Mapper07 {
	@Select("""
			<script>
			<bind name="pattern" value="'%' + key + '%'"/>
			SELECT
			CustomerID,
			CustomerName,
			ContactName,
			Address
			FROM Customers
			WHERE CustomerName LIKE #{pattern}
			ORDER BY CustomerID DESC
			</script>
			""")
	
	
List<Customer> sql1(String key);



@Select("""
		SELECT
		EmployeeID,
		LastName,
		FirstName
		FROM Employees
		WHERE LastName LIKE #{emfind} OR FirstName LIKE #{emfind}
		ORDER BY EmployeeID ASC
		""")
List<Employees>	sql2(String emfind);




@Select("""
		<script>
		SELECT COUNT(*)
		FORM Customers
		
		<if text="true">
		WHERE CustomerID = 10
		</if>
		</script>
		""")
Integer sql3();


@Select("""
		<script>
		SELECT COUNT(*)
		FROM Customers
		
		<if test="keyword neq null">
			<bind name="pattern" value="'%' + keyword + '%'"/>
			WHERE CustomerName LIKE #{pattern}
		</if>
		<if test="keyword == null">
			WHERE 1 = 1
		</if>
		</script>
		""")
Integer sql4(String keyword);


@Select("""
		<script>
		SELECT AVG(Price)
		FROM Products
		
		<if test="p != 0">
			WHERE CategoryId = #{p}
		</if>
		</script>
		""")
Double sql5(int p);

}