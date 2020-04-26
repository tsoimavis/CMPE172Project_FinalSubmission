package com.cmpe172_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe172_project.modal.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO
{
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Customer> get() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Query<Customer> query = currSession.createQuery("from Customer",
				Customer.class);
		
		List<Customer> list = query.getResultList();
		
		return list;
	}

	@Override
	public Customer get(int id) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Customer customer = currSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void save(Customer customer) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		currSession.saveOrUpdate(customer);
	}

	@Override
	public void delete(int id) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Customer customer = currSession.get(Customer.class, id);
		
		currSession.delete(customer);
	}
	
}
