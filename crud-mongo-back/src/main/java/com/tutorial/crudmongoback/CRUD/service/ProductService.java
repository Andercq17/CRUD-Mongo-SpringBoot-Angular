package com.tutorial.crudmongoback.CRUD.service;

import com.tutorial.crudmongoback.CRUD.dto.ProductDto;
import com.tutorial.crudmongoback.CRUD.entity.Product;
import com.tutorial.crudmongoback.CRUD.repository.ProductRepository;
import com.tutorial.crudmongoback.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product getOne(int id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
    }

    public Product save(ProductDto dto){
        int id=autoIncrement();
        Product prd= new Product(id,dto.getName(),dto.getPrice());
        return productRepository.save(prd);
    }
    public Product update(int id, ProductDto dto) throws ResourceNotFoundException {
        Product product=productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found"));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }
    public Product delete(int id) throws ResourceNotFoundException {
        Product product=productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found"));//en los get
        productRepository.delete(product);
        return product;
    }
    private int autoIncrement(){
        List<Product> products=productRepository.findAll();
        //Comparamos todos los id y obtenemos el id maximo
        return products.isEmpty()?1:
                products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
