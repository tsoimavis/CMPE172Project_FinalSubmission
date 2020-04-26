package com.cmpe172_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe172_project.modal.Customer;
import com.cmpe172_project.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	 @GetMapping("/customer")
	 public List<Customer> get() 
	 {
	  return customerService.get();
	 }
	 
	 @PostMapping("/customer")
	 public Customer save(@RequestBody Customer customer) 
	 {	 
	  customerService.save(customer);
	  return customer;
	 }
	 
	 @GetMapping("/customer/{id}")
	 public Customer get(@PathVariable int id) 
	 {
	  return customerService.get(id);
	 }
	 
	 @DeleteMapping("/customer/{id}")
	 public String delete(@PathVariable int id) 
	 {
	  
	  customerService.delete(id);
	  
	  return "Customer removed with id "+id;
	  
	 }
	 
	 @PutMapping("/customer")
	 public Customer update(@RequestBody Customer customer) 
	 {
	  customerService.save(customer);
	  return customer;
	 }
}
