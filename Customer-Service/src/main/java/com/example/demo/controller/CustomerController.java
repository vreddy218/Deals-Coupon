package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.repository.CustomerRepository;


@RestController
@CrossOrigin( "http://localhost:4200")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate template;
	
	
	@RequestMapping("/customer/categories")
	public String getAllCategories()
	{
		String url="http://localhost:8090/categories";
		return template.getForObject(url, String.class);
	}
	
	@RequestMapping("/customer/coupon")
	public String getAllCoupons()
	{
		String url="http://localhost:8090/coupon";
		return template.getForObject(url, String.class);
	}
}
