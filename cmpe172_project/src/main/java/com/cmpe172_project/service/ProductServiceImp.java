package com.cmpe172_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe172_project.dao.ProductDAO;
import com.cmpe172_project.modal.Product;

@Service
public class ProductServiceImp implements ProductService
{
	@Autowired
	private ProductDAO productDao;
	
	@Transactional
	@Override
	public List<Product> get() 
	{
		return productDao.get();
	}

	@Transactional
	@Override
	public Product get(int id) 
	{
		return productDao.get(id);
	}

	@Transactional
	@Override
	public void save(Product product) 
	{
		productDao.save(product);
	}

	@Transactional
	@Override
	public void delete(int id) 
	{
		productDao.delete(id);
	}

	@Transactional
	@Override
	public String getMeanPrice() 
	{
		return productDao.getMeanPrice();
	}

	@Override
	public String getMinPrice() 
	{
		return productDao.getMinPrice();
	}

	@Override
	public String getMaxPrice() 
	{
		return productDao.getMaxPrice();
	}


}
