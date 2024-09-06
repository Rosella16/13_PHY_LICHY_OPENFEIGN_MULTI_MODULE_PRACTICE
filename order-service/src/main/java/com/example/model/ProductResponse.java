package com.example.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductResponse {
    private Long productId;
    private String productName;
    private Double price;
}
