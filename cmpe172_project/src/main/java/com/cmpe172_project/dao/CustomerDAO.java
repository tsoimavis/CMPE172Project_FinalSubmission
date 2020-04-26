package com.cmpe172_project.dao;

import java.util.List;

import com.cmpe172_project.modal.Customer;

public interface CustomerDAO 
{
	List<Customer> get();
	
	Customer get(int id);
	
	void save(Customer customer);
	
	void delete(int id);
}
