package com.capg.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.Product.model.Product;
import com.capg.Product.repository.productRepo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RepositoryTest {

	@Autowired
	private productRepo repo;
	
	@Test
	public void saveTest() {
		
		Product  p= new Product("Samsung","1234","Coupon","1234","5");
		repo.save(p); 
		Product p2 = repo.findById(p.getProdName()).get(); 
		assertNotNull(p2);
		assertEquals(p.getProdName(), p2.getProdName());
			
	}

	@Test
	public void getAllTest() {
		Product  p1= new Product("Samsung","1234","Coupon","1234","5");
		Product p2= new Product("Apple","12","Coupon","1234","5");
		repo.save(p1); //save the Data in database
		repo.save(p2); // save the Data in Database
		List <Product> pList = (List<Product>) repo.findAll();
		assertEquals("Apple",pList.get(2).getProdName());
	}
		
}
