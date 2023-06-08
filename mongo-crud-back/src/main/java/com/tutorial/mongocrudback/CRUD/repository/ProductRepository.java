package com.tutorial.mongocrudback.CRUD.repository;

import com.tutorial.mongocrudback.CRUD.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {
    boolean existsByName(String name);
    Optional<Product> findByName(String name);
}
