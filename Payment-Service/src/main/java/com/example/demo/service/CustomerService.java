package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exceptions.CouponNotExistsException;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.model.Coupon;
import com.example.demo.model.Customer;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;
	@Autowired
	private CouponRepository couponRepository;
	
	
	public void purchaseCoupon(Customer customer,String code)throws CouponSystemException
	{
		this.isCustomerHasCoupon(customer.getId(),code,couponRepository);
		Coupon coupon = couponRepository.findById(code)
                .orElseThrow(() -> new CouponNotExistsException("This coupon doesn't exist."));
		
		 if (coupon.getAmount()>0) {

             coupon.setAmount(coupon.getAmount() - 1);
             couponRepository.save(coupon);

             customer.purchaseCoupon(coupon);
             customerRepository.save(customer);

		
	}

}


	private void isCustomerHasCoupon(String id, String code, CouponRepository couponRepository2) {
		// TODO Auto-generated method stub
		
	}
}
