package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Coupon;

public interface CouponRepository extends MongoRepository<Coupon,String> {

	Optional<Coupon> findCustomerCoupon(String id, String code);



}
