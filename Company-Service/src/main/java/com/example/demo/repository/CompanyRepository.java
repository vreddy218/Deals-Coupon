package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Company;



@Repository
public interface CompanyRepository extends MongoRepository<Company,String> {


	void deleteBycategories(String categories);




}
