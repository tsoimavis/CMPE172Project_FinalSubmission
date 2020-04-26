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
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer cus_ID;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
	@JsonIgnore
	private List<Sale> sales = new ArrayList<>();
	
	public Customer()
	{
		
	}
	
	public Customer(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Customer [cus_ID = " + cus_ID + 
				", name = " + name + ", email = "
				+ email + "]";
	}
	
	public Integer getCus_ID() 
	{
		return cus_ID;
	}

	public void setCus_ID(Integer cus_ID) 
	{
		this.cus_ID = cus_ID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
		
		for (Sale sale: sales)
		{
			sale.setCustomer(this);
		}
	}
	
	public void addSales(Sale sale)
	{
		sale.setCustomer(this);
		sales.add(sale);
	}
		
}
