package com.example.demo.domain;

import java.util.List;

import lombok.Data;

@Data
public class Supplier {
	
	private int id;
	private String SupplierId;
	private String SupplierName;
	private String ContactName;
	private String Address;
	private String City;
	private String PostalCode;
	private String Country;
	private String Phone;
	
	private List<Products> products;
	
}
