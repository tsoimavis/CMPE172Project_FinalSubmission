package com.cmpe172_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe172_project.dao.SaleDAO;
import com.cmpe172_project.modal.Sale;

@Service
public class SaleServiceImp implements SaleService
{
	@Autowired
	private SaleDAO saleDao;
	
	@Transactional
	@Override
	public List<Sale> get() 
	{
		return saleDao.get();
	}

	@Transactional
	@Override
	public Sale get(int id) 
	{
		return saleDao.get(id);
	}

	@Transactional
	@Override
	public void save(Sale sale) 
	{
		saleDao.save(sale);
	}

	@Transactional
	@Override
	public void delete(int id) 
	{
		saleDao.delete(id);
	}

	@Override
	public String getMostPurchased() 
	{
		return saleDao.getMostPurchased();
	}

	@Override
	public String getLeastPurchased() 
	{
		return saleDao.getLeastPurchased();
	}

	@Override
	public String getMostPopularCategory() 
	{
		return saleDao.getMostPopularCategory();
	}

	@Override
	public String getLeastPopularCategory() 
	{
		return saleDao.getLeastPopularCategory();
	}

	@Override
	public String getCustomerSpentMost() 
	{
		return saleDao.getCustomerSpentMost();
	}

}
