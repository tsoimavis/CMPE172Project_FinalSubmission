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

import com.cmpe172_project.modal.Sale;
import com.cmpe172_project.service.CustomerService;
import com.cmpe172_project.service.ProductService;
import com.cmpe172_project.service.SaleService;

@RestController
@RequestMapping("/api")
public class SaleController 
{
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
		
	 @GetMapping("/sale")
	 public List<Sale> get() 
	 {
	  return saleService.get();
	 }
	 
	 @PostMapping("/sale")
	 public Sale save(@RequestBody Sale sale) 
	 { 				 
		saleService.save(sale);		
		return sale;
	 }
	 
	 @GetMapping("/sale/{id}")
	 public Sale get(@PathVariable int id) 
	 {
	  return saleService.get(id);
	 }
	 
	 @DeleteMapping("/sale/{id}")
	 public String delete(@PathVariable int id) 
	 {
	  
	  saleService.delete(id);
	  
	  return "Sale removed with id "+id;
	  
	 }
	 
	 @PutMapping("/sale")
	 public Sale update(@RequestBody Sale sale) 
	 {
	  saleService.save(sale);
	  return sale;
	 }
}
