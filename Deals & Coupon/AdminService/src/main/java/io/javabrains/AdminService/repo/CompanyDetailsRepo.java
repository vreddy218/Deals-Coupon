package io.javabrains.AdminService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.javabrains.AdminService.model.CompanyDetails;

public interface CompanyDetailsRepo extends MongoRepository<CompanyDetails,String>{

}
