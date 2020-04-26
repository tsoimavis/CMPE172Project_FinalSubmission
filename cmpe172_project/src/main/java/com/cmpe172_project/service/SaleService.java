package com.cmpe172_project.service;

import java.util.List;

import com.cmpe172_project.modal.Sale;

public interface SaleService 
{
	List<Sale> get();
	
	Sale get(int id);
	
	void save(Sale sale);
	
	void delete(int id);
	
	String getMostPurchased();
	
	String getLeastPurchased();
	
	String getMostPopularCategory();
	
	String getLeastPopularCategory();
	
	String getCustomerSpentMost();
	
}
