package com.cmpe172_project.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer product_ID;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	@Column
	private String category;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	@JsonIgnore
	private List<Sale> sales = new ArrayList<>();
	
	@Override
	public String toString()
	{
		return "Product [product_ID = " + product_ID + 
				", name = " + name + ", price = "
				+ price + ", category = " + category + "]";
	}

	public Integer getProduct_ID() 
	{
		return product_ID;
	}

	public void setProduct_ID(Integer product_ID) 
	{
		this.product_ID = product_ID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
		
		for (Sale sale : sales)
		{
			sale.setProduct(this);
		}
	}
	
	public void addSales(Sale sale)
	{
		sale.setProduct(this);
		sales.add(sale);
	}
	
	
	
	
}
