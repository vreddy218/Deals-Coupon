package io.javabrains.AdminService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.javabrains.AdminService.model.CompanyDetails;
import io.javabrains.AdminService.model.Customer;
import io.javabrains.AdminService.repo.CompanyDetailsRepo;
import io.javabrains.AdminService.repo.UserRepo;

public class AdminService {
	//User
		@Autowired
		private UserRepo userRepo;

		//Company
		@Autowired
		private CompanyDetailsRepo  companyRepo;


		/**
		 * User methods
		 */

		public List<Customer> getAllCustomers()
		{
			List<Customer> users=new ArrayList<>();
			userRepo.findAll()
			.forEach(users::add);
			return users;
		}

		public Customer addCustomer(Customer customer)

		{
			return userRepo.save(customer);
		}
		public void UpdateCustomer(String id, Customer customer) {
			userRepo.save(customer);

		}
		public void deleteCustomer(String id) {
			userRepo.deleteById(id);

		}
		
		 /**
	     * COMPANY methods
	     */
		
		public List<CompanyDetails> getAllCompany()
		{
			List<CompanyDetails> companies=new ArrayList<>();
			companyRepo.findAll()
			.forEach(companies::add);
			return companies;
		}

		public void createCompany(CompanyDetails company)

		{
			companyRepo.save(company);
		}
		
		public void UpdateCompany(String id, CompanyDetails company) {
			companyRepo.save(company);

		}
		
		public void deleteCompany(String id) {
			companyRepo.deleteById(id);

		}

}
