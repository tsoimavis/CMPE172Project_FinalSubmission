package com.cmpe172_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe172_project.modal.Product;

@Repository
public class ProductDAOImp implements ProductDAO
{
	@Autowired
	private EntityManager entityManager;
		
	@Override
	public List<Product> get() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Query<Product> query = currSession.createQuery("from Product",
				Product.class);
		
		List<Product> list = query.getResultList();
		
		return list;
	}

	@Override
	public Product get(int id) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Product product = currSession.get(Product.class, id);
		
		return product;
	}

	@Override
	public void save(Product product) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		currSession.saveOrUpdate(product);
	}

	@Override
	public void delete(int id) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Product product = currSession.get(Product.class, id);
		
		currSession.delete(product);
	}

	@Override
	public String getMeanPrice() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Double meanPrice =  (Double) currSession.createQuery("select avg(price) from Product")
				.getSingleResult();
		
		return Double.toString(meanPrice);
	}

	@Override
	public String getMinPrice() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Double minPrice = (Double) currSession.createQuery("select min(price) from Product")
				.getSingleResult();
		
		return Double.toString(minPrice);
	}

	@Override
	public String getMaxPrice() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Double maxPrice = (Double) currSession.createQuery("select max(price) from Product")
				.getSingleResult();
		
		return Double.toString(maxPrice);
	}

}
