package com.cmpe172_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe172_project.modal.Sale;

@Repository
public class SaleDAOImp implements SaleDAO
{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Sale> get() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Query<Sale> query = currSession.createQuery("from Sale",
				Sale.class);
		
		List<Sale> list = query.getResultList();
		
		return list;
	}

	@Override
	public Sale get(int id) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Sale sale = currSession.get(Sale.class, id);
		
		return sale;
	}

	@Override
	public void save(Sale sale) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		currSession.saveOrUpdate(sale);
	}

	@Override
	public void delete(int id) 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		Sale sale = currSession.get(Sale.class, id);
		
		currSession.delete(sale);
	}

	@Override
	public String getMostPurchased() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		List<Object[]> orderedPurchased = currSession.createQuery(
			"select p.name, sum(s.quantity) as quantity from Product p join p.sales s "
			+ "group by p.name order by quantity desc").setMaxResults(1).getResultList();
		
		String mostPurchasedName = (String) orderedPurchased.get(0)[0];
						
		Long mostPurchasedQuantity = (Long) orderedPurchased.get(0)[1];
		
		return mostPurchasedName + ", " + Long.toString(mostPurchasedQuantity);				
	}

	@Override
	public String getLeastPurchased() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		List<Object[]> orderedCategory = currSession.createQuery(
			"select p.name, sum(s.quantity) as quantity from Product p join p.sales s "
			+ "group by p.name order by quantity").setMaxResults(1).getResultList();
		
		String leastPurchasedName = (String) orderedCategory.get(0)[0];
						
		Long leastPurchasedQuantity = (Long) orderedCategory.get(0)[1];
		
		return leastPurchasedName + ", " + Long.toString(leastPurchasedQuantity);
	}

	@Override
	public String getMostPopularCategory() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		List<Object[]> orderedCategory = currSession.createQuery(
			"select p.category, sum(s.quantity) as quantity from Product p join p.sales s "
			+ "group by p.category order by quantity desc").setMaxResults(1).getResultList();
		
		String mostPopCategoryName = (String) orderedCategory.get(0)[0];
		
		Long mostPopCategoryQuantity = (Long) orderedCategory.get(0)[1];
		
		return mostPopCategoryName + ", " + Long.toString(mostPopCategoryQuantity);
	}

	@Override
	public String getLeastPopularCategory() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		List<Object[]> orderedPurchased = currSession.createQuery(
			"select p.category, sum(s.quantity) as quantity from Product p join p.sales s "
			+ "group by p.category order by quantity").setMaxResults(1).getResultList();
		
		String leastPopCategoryName = (String) orderedPurchased.get(0)[0];
		
		Long leastPopCategoryQuantity = (Long) orderedPurchased.get(0)[1];
		
		return leastPopCategoryName + ", " + Long.toString(leastPopCategoryQuantity);
	}

	@Override
	public String getCustomerSpentMost() 
	{
		Session currSession = entityManager.unwrap(Session.class);
		
		List<Object[]> orderedCustomers = currSession.createNativeQuery(
		"select customer.name, sum(price * quantity) as total from "
		+ "customer natural join sale, product where product.product_ID=sale.product_ID "
		+ "group by customer.name order by total desc").setMaxResults(1).getResultList();
		
		String customerName = (String) orderedCustomers.get(0)[0];
		
		Double total = (Double) orderedCustomers.get(0)[1];
		
		return customerName + ", " + Double.toString(total);
	}

}
