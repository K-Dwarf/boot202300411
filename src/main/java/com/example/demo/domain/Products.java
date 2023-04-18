package com.example.demo.domain;

import lombok.Data;

@Data
public class Products {

	int productId;
	String productName;
	int supplierId;
	int categoryId;
	String unit;
	double price;
	
	
}
