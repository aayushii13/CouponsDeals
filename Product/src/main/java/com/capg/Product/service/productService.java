package com.capg.Product.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.Product.model.Deals;
import com.capg.Product.model.Product;
import com.capg.Product.repository.DealsRepository;
import com.capg.Product.repository.productRepo;

@Service
public class productService {

	@Autowired
	private productRepo repo;
	
	@Autowired
	private DealsRepository deal_Repo;

	public Product addProduct(Product product) {
		
		product.setCoupon(CouponGenerator());
		product.setCashBack(cashBackGenerator());
		repo.save(product);
		return product;
	}

	public List<Product> getProd() {
		return repo.findAll();
	}

	public void del_prod(String name) {
		repo.deleteById(name);
		
	}

	public Product updt_prod(Product product, String name) {
		repo.deleteById(name);
		repo.save(product);
		return product;
		
	}
	
	public String CouponGenerator(){
		
		Random rand=new Random();
		int num1= 65+ rand.nextInt(26);
		int num2 = 97+ rand.nextInt(26);
		int num3= rand.nextInt(10);
		int num4= rand.nextInt(10);
		int num5= 65+ rand.nextInt(26);
		char c1=(char)num1;
		char c2=(char)num2;
		String s3=Integer.toString(num3);
		String s4=Integer.toString(num4);
		char c5=(char)num5;
		String s1=String.valueOf(c1);
		String s2=String.valueOf(c2);
		String s5=String.valueOf(c5);
		s1=s1.concat(s2);
		s1=s1.concat(s3);
		s1=s1.concat(s4);
		s1=s1.concat(s5);
		 return s1;
	}
	
	public String cashBackGenerator() {
		
		Random rand=new Random();
		int cashback=rand.nextInt(10);
		String cash="Cashback received =";
		String cashs=Integer.toString(cashback);
		cash=cash.concat(cashs);
		return cash;
	}

	public Deals updt_Deals(Deals deals, String name) {
		deal_Repo.deleteById(name);
		deal_Repo.save(deals);
		return deals;
	}

	public String del_Deals(String name) {
		deal_Repo.deleteById(name);
		return "deal deleted";
	}


	public List<Deals> getDeals() {
		return deal_Repo.findAll();
	}

	public Deals addDeals(Deals deals) {
		
		deal_Repo.save(deals);
		return deals;
	}
	
	
}
