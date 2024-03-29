package com.capg.Product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.Product.model.Deals;

public interface DealsRepository extends MongoRepository<Deals, String> {

}
