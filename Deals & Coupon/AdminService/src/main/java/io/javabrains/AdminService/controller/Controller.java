package io.javabrains.AdminService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.AdminService.model.CompanyDetails;
import io.javabrains.AdminService.model.Customer;
import io.javabrains.AdminService.service.AdminService;

@RestController
public class Controller {
	
		@Autowired
		private AdminService adminService;
		
		@Autowired
		private RestTemplate template;
		
		//user details
		
		@RequestMapping("/user")
		public List<Customer> getAllCustomers()
		{
			return adminService.getAllCustomers();
		}
		
		//create new user details
		
		@RequestMapping(method=RequestMethod.POST, value="/user")
		public Customer addCustomer(@RequestBody Customer customer)
		{
		return adminService.addCustomer(customer);
		}
		
		//update user details by ID
		
		@RequestMapping(method=RequestMethod.PUT, value="/user/{id}")
		public void UpdateCustomer(@RequestBody Customer customer,@PathVariable String id)
		{
		   adminService.UpdateCustomer(id,customer);
		}
		
		//delete user details by ID
		
		@RequestMapping(method=RequestMethod.DELETE, value="/user/{id}")
		public void deleteCustomer(@PathVariable String id)
		{
		   adminService.deleteCustomer(id);
		}
		
		// get company details
		
		@RequestMapping("/companydetails")
		public List<CompanyDetails> getAllCompanyDetails()
		{
			return adminService.getAllCompany();
		}
		
		//create new company details
		
		@RequestMapping(method=RequestMethod.POST, value="/companydetails")
		public void createCompany(@RequestBody CompanyDetails company)
		{
		    adminService.createCompany(company);
		}
		
		//update company details by ID
		
		@RequestMapping(method=RequestMethod.PUT, value="/companydetails/{id}")
		public void UpdateCompany(@RequestBody CompanyDetails company,@PathVariable String id)
		{
		   adminService.UpdateCompany(id,company);
		}
		
		//delete company details by ID
		
		@RequestMapping(method=RequestMethod.DELETE, value="/companydetails/{id}")
		public void deleteCompany(@PathVariable String id)
		{
		   adminService.deleteCompany(id);
		}
		
		
		//GET COMAPANY DETAILS FROM COMPANY SERVICE(INTERCONNECTION)
		
		@RequestMapping("/company/admin")
		public String getAllCompany()
		{
			String url="http://localhost:8093/company";
			return template.getForObject(url, String.class);
		}
}
