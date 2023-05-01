package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper08 {
	
	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			
			<where>
				<if test= "id lt 5">   
					CustomerID &lt; 5
				</if>
			</where>
			
			
			</script>
			""")
	public Integer sql1(Integer id);
	
	
	@Select("""
			SELECT COUNT(*)
			FROM Customers
			WHERE CustomerID < #{id}
					
			""")
	public Integer sql2(Integer id);
	
	
	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			WHERE CustomerID &lt; #{id}
			</script>
			""")
	public Integer sql3(Integer id);
	
	
	@Select("""
			<script>
			<![CDATA[
			SELECT COUNT(*)
			FROM Customers
			WHERE CustomerID < #{id}
			]]>
			<where>
			<if test="true">
			<![CDATA[
			OR CustomerID < #{id}
			]]>
			</if>
			</where>
			</script>
			""")
	public Integer sql4(Integer id);
}