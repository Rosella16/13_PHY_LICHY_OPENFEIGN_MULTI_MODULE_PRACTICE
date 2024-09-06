package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductRequest {
    private String productName;
    private Double price;

    public Product toProduct(){
        return new Product(null, this.productName, this.price);
    }
    public Product toProduct(Long id){
        return new Product(id, this.productName, this.price);
    }

}
