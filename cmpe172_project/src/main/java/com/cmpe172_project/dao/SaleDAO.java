package com.cmpe172_project.dao;

import java.util.List;

import com.cmpe172_project.modal.Sale;

public interface SaleDAO 
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
