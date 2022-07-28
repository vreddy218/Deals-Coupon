package io.javabrains.AdminService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.javabrains.AdminService.model.Customer;

public interface UserRepo extends MongoRepository<Customer,String>{

}
