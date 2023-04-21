package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.demo.domain.Shippers;

@Mapper
public interface Mymapper01 {

	@Insert("""
			INSERT INTO Shippers(
			
			ShipperName,
			Phone)
			VALUES(
			
			#{ShipperName},
			#{Phone})
			""")
	@Options(useGeneratedKeys = true,keyProperty = "ShipperID")
	int mysql01(Shippers shipper);
			
			
	
	@Insert("""
			INSERT INTO Shippers(ShipperID,ShipperName,Phone)
			VALUES (#{ShipperID},#{ShipperName},#{Phone})
			""")
	int Mysql02(Shippers shipper);

}
