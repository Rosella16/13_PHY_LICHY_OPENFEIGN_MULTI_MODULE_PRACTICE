package com.example.client;

import com.example.model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name ="product-service", url="http://localhost:8082/api/v1/product")
public interface ProductFeignClient {
    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id);
}
