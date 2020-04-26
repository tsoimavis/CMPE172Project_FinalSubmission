package com.cmpe172_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe172_project.service.CustomerService;
import com.cmpe172_project.service.ProductService;
import com.cmpe172_project.service.SaleService;

@RestController
@RequestMapping("/api")
public class Analytics 
{
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/analytics")
	 public List<String> get() 
	 {
	  	List<String> queryResults = new ArrayList<>();
	  	
	  	queryResults.add(productService.getMinPrice());
	  	queryResults.add(productService.getMeanPrice());
	  	queryResults.add(productService.getMaxPrice());
	  	queryResults.add(saleService.getMostPurchased());
	  	queryResults.add(saleService.getLeastPurchased());
	  	queryResults.add(saleService.getMostPopularCategory());
	  	queryResults.add(saleService.getLeastPopularCategory());
	  	queryResults.add(saleService.getCustomerSpentMost());
	  	
	  	return queryResults;
	 }
}
