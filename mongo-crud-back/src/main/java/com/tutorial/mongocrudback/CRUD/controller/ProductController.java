package com.tutorial.mongocrudback.CRUD.controller;

import com.tutorial.mongocrudback.CRUD.dto.ProductDto;
import com.tutorial.mongocrudback.CRUD.entity.Product;
import com.tutorial.mongocrudback.CRUD.service.ProductService;
import com.tutorial.mongocrudback.global.exceptions.AttributeException;
import com.tutorial.mongocrudback.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product") //this is the way how we can instance the mapping - >localhost:8000/product
public class ProductController {
    @Autowired
    ProductService productService;

    //mapping get with just the url -> localhost:8000/product
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    //mapping get with url/id -> localhost:8000/product/id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getOne(id));
    }
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto dto) throws AttributeException {
        return ResponseEntity.ok(productService.save(dto));
    }

    //mapping get with url/id -> localhost:8000/product/id
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody ProductDto dto) throws ResourceNotFoundException, AttributeException {
        return ResponseEntity.ok(productService.update(id,dto));
    }

    //mapping delete with url/id -> localhost:8000/product/id
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.delete(id));
    }
}
