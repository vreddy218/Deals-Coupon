package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CompanyDetails;
import com.example.demo.model.Customer;
import com.example.demo.repository.CompanyDetailsRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AdminService {
		@Autowired
		private UserRepository userRepository;

		@Autowired
		private CompanyDetailsRepository  companyRepository;


		public List<Customer> getAllCustomers()
		{
			List<Customer> users=new ArrayList<>();
			userRepository.findAll()
			.forEach(users::add);
			return users;
		}

		public Customer addCustomer(Customer customer)

		{
			return userRepository.save(customer);
		}
		public void UpdateCustomer(String id, Customer customer) {
			userRepository.save(customer);

		}
		public void deleteCustomer(String id) {
			userRepository.deleteById(id);

		}
	
		public List<CompanyDetails> getAllCompany()
		{
			List<CompanyDetails> companies=new ArrayList<>();
			companyRepository.findAll()
			.forEach(companies::add);
			return companies;
		}

		public void createCompany(CompanyDetails company)

		{
			companyRepository.save(company);
		}
		
		public void UpdateCompany(String id, CompanyDetails company) {
			companyRepository.save(company);

		}
		
		public void deleteCompany(String id) {
			companyRepository.deleteById(id);

		}



}
