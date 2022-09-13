package com.example.demo.component;

import org.springframework.stereotype.Component;


import com.example.demo.exceptions.CompanyNotExistsException;
import com.example.demo.exceptions.CouponNotExistsException;
import com.example.demo.exceptions.CustomerAlreadyHasCouponException;
import com.example.demo.model.Coupon;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.CouponRepository;
import java.util.Optional;

@Component
public interface Validations {

	default void isCompanyExists(String id, CompanyRepository companyRepository) throws CompanyNotExistsException {
		companyRepository.findById(id)
		.orElseThrow(() -> new CompanyNotExistsException("This company doesn't exist."));
	}

	default void isCouponExists(String code, CouponRepository couponRepository) throws CouponNotExistsException {
		couponRepository.findById(code)
		.orElseThrow(() -> new CouponNotExistsException("This coupon doesn't exist."));
	}


	default void isCustomerHasCoupon(String id, String code, CouponRepository couponRepository) throws CustomerAlreadyHasCouponException {
		Optional<Coupon> isCustomerHasCoupon = couponRepository.findCustomerCoupon(id, code);
		if (isCustomerHasCoupon.isPresent()) {
			throw new CustomerAlreadyHasCouponException("You already have this coupon.");
		}
	}
}
