package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.model.Company;
import com.example.demo.model.Coupon;
import com.example.demo.model.Coupons_Sequence;
import com.example.demo.repository.CategoriesRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.CouponRepository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service
public class CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	public CompanyService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}


	public int getSequenceNumber(String sequenceName) {

		Query query = new Query(Criteria.where("availcoupons").is(sequenceName));
		
		Update update = new Update().inc("seq", 1);
		
		Coupons_Sequence counter = mongoOperations
				.findAndModify(query,
						update, options().returnNew(true).upsert(true),
						Coupons_Sequence.class);

		return (!Objects.isNull(counter) ? counter.getSeq() : 1);
	}

	public List<Coupon> getAllCoupon()
	{
		List<Coupon> coupon=new ArrayList<>();
		couponRepository.findAll()
		.forEach(coupon::add);
		return coupon;
	}

	public void addCoupon(Coupon coupon)

	{
		couponRepository.save(coupon);
	}
	public void UpdateCoupon(String code, Coupon coupon) {
		couponRepository.save(coupon);

	}
	public void deleteCoupon(String code) {
		couponRepository.deleteByCode(code);



	}

	 
	public List<Company> getAllCategories()
	{
		List<Company> coupon=new ArrayList<>();
		companyRepository.findAll()
		.forEach(coupon::add);
		return coupon;
	}

	public void addCategories(Company company)

	{
		companyRepository.save(company);
	}
	public void UpdateCategories(String id, Company company) {
		companyRepository.save(company);

	}
	public void deleteCategories(String id) {
		companyRepository.deleteById(id);



	}


	
	
}
