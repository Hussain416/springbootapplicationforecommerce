package com.mobile.demo.service;

import com.mobile.demo.Exception.OutOfStockException;
import com.mobile.demo.Exception.ProductNotFoundException;
import com.mobile.demo.entity.Order;
import com.mobile.demo.entity.OrderDetail;
import com.mobile.demo.entity.Product;
import com.mobile.demo.repository.OrderRepository;
import com.mobile.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

//    @Transactional
//    public Order createOrder(Order order, List<OrderDetail> orderDetails) {
//        double totalAmount = 0.0;
//
//        for (OrderDetail orderDetail : orderDetails) {
//            Product product = orderDetail.getProduct();
//
//            if (product == null) {
//                throw new IllegalArgumentException("Product cannot be null in order detail");
//            }
//
//            product = productRepository.findById(product.getProductid())
//                    .orElseThrow(() -> new RuntimeException("Product not found"));
//
//            if (product.getStockQuantity() < orderDetail.getQuantity()) {
//                throw new OutOfStockException("Not enough stock for product: " + product.getProductName());
//            }
//
//            if (product.getStockQuantity() == 0) {
//                throw new OutOfStockException("The product you are looking for is currently out of stock: " + product.getProductName());
//            }
//
//            product.setStockQuantity(product.getStockQuantity() - orderDetail.getQuantity());
//            productRepository.save(product);
//
//            orderDetail.setProduct(product);
//            totalAmount += product.getPrice() * orderDetail.getQuantity();
//            orderDetail.setOrder(order);
//        }
//
//        order.setTotalAmount(totalAmount);
//        order.setOrderDetails(orderDetails);
//
//        return orderRepository.save(order);
//    }

    @Transactional
    public Order createOrder(Order order, List<OrderDetail> orderDetails) {
        double totalAmount = 0.0;

        for (OrderDetail orderDetail : orderDetails) {
            Product product = orderDetail.getProduct();

            if (product == null) {
                throw new IllegalArgumentException("Product cannot be null in order detail");
            }

            product = productRepository.findById(product.getProductid())
                    .orElseThrow(() -> new ProductNotFoundException("Product not found"));

            if (product.getStockQuantity() < orderDetail.getQuantity()) {
                throw new OutOfStockException("Not enough stock for product: " + product.getProductName());
            }

            if (product.getStockQuantity() == 0) {
                throw new OutOfStockException("The product you are looking for is currently out of stock: " + product.getProductName());
            }

            product.setStockQuantity(product.getStockQuantity() - orderDetail.getQuantity());
            productRepository.save(product);

            orderDetail.setProduct(product);
            totalAmount += product.getPrice() * orderDetail.getQuantity();
            orderDetail.setOrder(order);
        }

        order.setTotalAmount(totalAmount);
        order.setOrderDetails(orderDetails);

        return orderRepository.save(order);
    }

   
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
