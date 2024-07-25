package com.mobile.demo.controller;

import com.mobile.demo.entity.Order;
import com.mobile.demo.entity.OrderDetail;
import com.mobile.demo.entity.Product;
import com.mobile.demo.service.OrderService;
import com.mobile.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order, order.getOrderDetails());
        return orderService.getOrderById(createdOrder.getOrderid());
    }
//    @PutMapping("/{productId}/quantity")
//    public Product updateProductQuantity(@PathVariable Long productId, @RequestParam int quantity) {
//        return productService.updateProductQuantity(productId, quantity);
//    }
}
