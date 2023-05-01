package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import com.example.demo.domain.Customer;

@Mapper
public interface Mapper06 {
	
	@Select("""
			
			SELECT CustomerID,
			CustomerName,
			Address
			FROM Customers
			ORDER BY CustomerId DESC
			LIMIT #{startIndex},15
			
			""")

	List<Customer> listCustomer(Integer startIndex);

	
	
	@Select("""
			SELECT COUNT(*)FROM Customers
			""")
	Integer countAll();

	
}
