package com.capg.Product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.Product.model.Product;

public interface productRepo extends MongoRepository<Product, String> {

}
