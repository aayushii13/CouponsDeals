package com.capg.Product;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.Product.model.Product;
import com.capg.Product.repository.productRepo;
import com.capg.Product.service.productService;

@SpringBootTest(classes= {ServiceTest.class})
public class ServiceTest {

	@Mock
	private productRepo repo;
	
	
	@InjectMocks
	private productService prodService;
	
	
	
	@Test
	@Order(1)
	public void test_GetAll() {
		
		List<Product> prodList=new ArrayList<>();
		prodList.add(new Product("Samsung","1234","Coupon","1234","5"));
		prodList.add(new Product("Apple","12","Coupon","1234","5"));
		prodList.add(new Product("Lenovo","1234","Coupon","1234","5"));
		when(repo.findAll()).thenReturn(prodList);
		assertEquals(3,prodService.getProd().size());
	}
	
	
	@Test
	@Order(2)
	public void test_delProducts() {

		Product p=new Product("Samsung","1234","Coupon","1234","5");
		prodService.del_prod(p.getProdName());
		verify(repo,times(1)).deleteById("Samsung");
	}
	
	@Test
	@Order(3)
	public void test_updtProducts() {

		Product p=new Product("Samsung","1234","Coupon","1234","5");
		Product p2=new Product("Apple","1234","Coupon","1234","5");
		Optional<Product> prodList=Optional.of(p2);
		
		when(repo.findById(p.getProdName())).thenReturn(prodList);
		assertEquals(p2,prodService.updt_prod(p2, "Samsung"));
	}
	
	@Test
	@Order(4)
	public void test_addProducts() {

		Product p=new Product("Samsung","1234","Coupon","1234","5");
		when(repo.save(p)).thenReturn(p);
		assertEquals(p,prodService.addProduct(p));
	}
	
	
}
