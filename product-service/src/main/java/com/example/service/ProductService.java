package com.example.service;

import com.example.model.Product;
import com.example.model.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct (ProductRequest productRequest);

    List<Product> findAll();

    Product findById(Long id);

    void deleteById(Long id);

    Product updateProduct(Long id, ProductRequest productRequest);
}
