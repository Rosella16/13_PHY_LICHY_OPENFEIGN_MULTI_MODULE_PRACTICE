package com.example.controller;

import com.example.model.ApiResponse;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody OrderRequest orderRequest) {
        ApiResponse<OrderResponse> response = ApiResponse.<OrderResponse>builder()
                .message("successfully created order")
                .payload(orderService.createOrder(orderRequest))
                .status(HttpStatus.CREATED)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrderById(@PathVariable Long id) {
        ApiResponse<OrderResponse> response = ApiResponse.<OrderResponse>builder()
                .message("Order found")
                .payload(orderService.getOrderById(id))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


}
