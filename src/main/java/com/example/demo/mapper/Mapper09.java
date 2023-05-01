package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Supplier;

@Mapper
public interface Mapper09 {

	@Select("""
			<script>
				SELECT COUNT(*)
				FROM Customers
			WHERE country IN (
				
				<foreach collection="elems" item="elem" separator=", ">
					#{elem}
				</foreach>
				
				)
			</script>
			""")
	Integer sql1(List<String> elems);
	
	
	
	@Select("""
		    <script>
		    SELECT  
		        SupplierId,
		        SupplierName,
		        ContactName,
		        Address,
		        Country,
		        PostalCode,
		        Phone

		    FROM Suppliers
		    <where>
		    <if test="country neq null">
		    Country IN(
		    
		    <foreach collection="country" item="item" separator=",">
		    #{item}
		    </foreach>
		    )
		    </if>
		    </where>
		    </script>
		""")
		List<Supplier> sql2(List<String> country);
	
}


