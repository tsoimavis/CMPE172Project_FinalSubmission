package com.cmpe172_project.service;

import java.util.List;

import com.cmpe172_project.modal.Customer;

public interface CustomerService 
{
	List<Customer> get();
	
	Customer get(int id);
	
	void save(Customer customer);
	
	void delete(int id);
}
