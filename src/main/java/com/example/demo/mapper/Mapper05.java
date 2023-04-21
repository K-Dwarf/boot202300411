package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Customer;

@Mapper
public interface Mapper05 {

	@Update("""

			UPDATE MyTable39
			SET
				Col2 = '수정된값'
				col3 = 34
			""")
	int sql1();

	@Update("""
			UPDATE MyTable39
			SET
			Col2 = #{val1},
			Col3 = #{val2}
			WHERE
			Col1 = #{key}
			""")
	String sql2(int key, String val1, Integer val2);

	@Update("""
			UPDATE Customers
			SET
			CustomerName = #{customerName},
			Country = #{country}
			WHERE
			CustomerID = #{customerId}
			""")
	int sql3(int customerId, String customerName, String country);
// ******************** ******************** ********************
	@Update("""
			 UPDATE Customers
			SET
			CustomerName = #{customerName},
			Country = #{country},
			ContactName = #{contactName},
			Address = #{address},
			City = #{city}
			WHERE
			CustomerId = #{customerId}
			""")
	int sql4(Customer customer);

	@Select("""
			SELECT CustomerId,
			CustomerName ,
			ContactName,
			address,
			city,
			postalCode,
			country
			FROM Customers
			WHERE CustomerId = #{id}
			""")
	Customer sql5(Integer id);
// ******************** ******************** ********************	
}
