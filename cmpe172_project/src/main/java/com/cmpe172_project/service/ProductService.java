package com.cmpe172_project.service;

import java.util.List;

import com.cmpe172_project.modal.Product;

public interface ProductService 
{
	List<Product> get();
	
	Product get(int id);
	
	void save(Product product);
	
	void delete(int id);
	
	String getMeanPrice();
	
	String getMinPrice();
	
	String getMaxPrice();
}
