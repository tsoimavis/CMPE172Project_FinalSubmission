package com.cmpe172_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe172_project.dao.CustomerDAO;
import com.cmpe172_project.modal.Customer;

@Service
public class CustomerServiceImp implements CustomerService 
{
	@Autowired
	private CustomerDAO customerDao;
	
	@Transactional
	@Override
	public List<Customer> get() 
	{
		return customerDao.get();
	}

	@Transactional
	@Override
	public Customer get(int id) 
	{
		return customerDao.get(id);
	}

	@Transactional
	@Override
	public void save(Customer customer)
	{
		customerDao.save(customer);
	}

	@Transactional
	@Override
	public void delete(int id) 
	{
		customerDao.delete(id);
	}

}
