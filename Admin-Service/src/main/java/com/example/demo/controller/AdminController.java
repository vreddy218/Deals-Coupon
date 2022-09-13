package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CompanyDetails;
import com.example.demo.model.Customer;
import com.example.demo.service.AdminService;
@Controller
@RestController
@CrossOrigin( "http://localhost:4200")
public class AdminController {
	
		@Autowired
		private AdminService adminService;
		
		@Autowired
		private RestTemplate template;
		
		
		@RequestMapping("/user")
		public List<Customer> getAllCustomers()
		{
			return adminService.getAllCustomers();
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/user")
		public Customer addCustomer(@RequestBody Customer customer)
		{
		return adminService.addCustomer(customer);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/user/{id}")
		public void UpdateCustomer(@RequestBody Customer customer,@PathVariable String id)
		{
		   adminService.UpdateCustomer(id,customer);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/user/{id}")
		public void deleteCustomer(@PathVariable String id)
		{
		   adminService.deleteCustomer(id);
		}
		
		
		@RequestMapping("/companydetails")
		public List<CompanyDetails> getAllCompanyDetails()
		{
			return adminService.getAllCompany();
		}
		
	
		@RequestMapping(method=RequestMethod.POST, value="/companydetails")
		public void createCompany(@RequestBody CompanyDetails company)
		{
		    adminService.createCompany(company);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/companydetails/{id}")
		public void UpdateCompany(@RequestBody CompanyDetails company,@PathVariable String id)
		{
		   adminService.UpdateCompany(id,company);
		}
	
		@RequestMapping(method=RequestMethod.DELETE, value="/companydetails/{id}")
		public void deleteCompany(@PathVariable String id)
		{
		   adminService.deleteCompany(id);
		}


		public RestTemplate getTemplate() {
			return template;
		}


		public void setTemplate(RestTemplate template) {
			this.template = template;
		}
}
