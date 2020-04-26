package com.cmpe172_project.modal;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Integer sale_ID;
	
	@ManyToOne
	@JoinColumn(name="cus_ID", referencedColumnName="cus_ID", nullable=false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="product_ID", referencedColumnName="product_ID", nullable=false)
	private Product product;
	
	@Column
	private Integer quantity;
	
	@Column
	private Timestamp time;
	
	public Sale()
	{
		
	}
	
	public Sale(Integer id)
	{
		this.sale_ID = id;
	}
	
	@Override
	public String toString()
	{
		return "Sale [sale_ID = " + sale_ID + 
				", cus_ID = " + customer.getCus_ID() + ", product_ID = "
				+ product.getProduct_ID() + ", quantity = " + quantity +
				", time = " + time + "]";
	}

	public Integer getSale_ID() 
	{
		return sale_ID;
	}

	public void setSale_ID(Integer sale_ID) 
	{
		this.sale_ID = sale_ID;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}

	public Timestamp getTime() 
	{
		return time;
	}

	public void setTime(Timestamp time) 
	{
		this.time = time;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}	
	
	
}
