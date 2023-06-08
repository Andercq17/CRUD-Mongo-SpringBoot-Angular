package com.tutorial.crudmongoback.CRUD.controller;

import com.tutorial.crudmongoback.CRUD.dto.ProductDto;
import com.tutorial.crudmongoback.CRUD.entity.Product;
import com.tutorial.crudmongoback.CRUD.service.ProductService;
import com.tutorial.crudmongoback.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product") //asi se instancia el mapeo - >localhost:8000/product
public class ProductController {
    @Autowired
    ProductService productService;

    //mapeo get con solo la url -> localhost:8000/product
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    //mapeo get con la url/id -> localhost:8000/product/id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getOne(id));
    }
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }

    //mapeo get con la url/id -> localhost:8000/product/id
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody ProductDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.update(id,dto));
    }

    //mapeo get con la url/id -> localhost:8000/product/id
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.delete(id));
    }
}
