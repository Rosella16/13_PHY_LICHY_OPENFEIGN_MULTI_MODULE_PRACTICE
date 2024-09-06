package com.example.service.serviceImpl;

import com.example.model.Product;
import com.example.model.ProductRequest;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(productRequest.toProduct());
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(null);
        if (product ==null) {throw new IllegalStateException("Product with ID not found" + id);
        }
        return product;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow();
        return productRepository.save(productRequest.toProduct());
    }
}

