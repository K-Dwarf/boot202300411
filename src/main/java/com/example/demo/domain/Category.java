package com.example.demo.domain;

import java.util.List;

import lombok.Data;

@Data
public class Category {

	private Integer id;
	private String name;
	private String description;

	private List<Products> products;
}
