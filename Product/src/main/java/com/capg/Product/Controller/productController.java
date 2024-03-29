package com.capg.Product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.Product.model.Deals;
import com.capg.Product.model.Product;
import com.capg.Product.service.productService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class productController {

	@Autowired
	private productService prodService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		prodService.addProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@GetMapping("/GetProducts")
	public List<Product> getProduct(){
		return prodService.getProd();
	}
	
	@DeleteMapping("/deleteProducts/{name}")
	public String deleteProduct(@PathVariable("name") String name) {
		prodService.del_prod(name);
		return "Product deleted";
	}
	
	@PutMapping("/updateProducts/{name}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("name") String name) {
		return  prodService.updt_prod(product,name);
	}
	
	@GetMapping("/GetDeals")
	public List<Deals> getDeals(){
		return prodService.getDeals();
	}
	
	@PostMapping("/addDeals")
	public ResponseEntity<Deals> addDeals(@RequestBody Deals deals) {
		
		prodService.addDeals(deals);
		return new ResponseEntity<>(deals, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteDeals/{name}")
	public String deleteDeals(@PathVariable("name") String name) {
		prodService.del_Deals(name);
		return "Deal deleted";
	}
	
	@PutMapping("/updateDeals/{name}")
	public Deals updateDeals(@RequestBody Deals deals, @PathVariable("name") String name) {
		return  prodService.updt_Deals(deals,name);
	}
}
