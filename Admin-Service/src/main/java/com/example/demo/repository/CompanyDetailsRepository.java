package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CompanyDetails;


@Repository
public interface CompanyDetailsRepository extends MongoRepository<CompanyDetails,String>{

}
