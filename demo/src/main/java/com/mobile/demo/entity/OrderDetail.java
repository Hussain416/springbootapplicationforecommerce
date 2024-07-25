package com.mobile.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderdetailid;

    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonBackReference(value = "order-details")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties("orderDetails")
    private Product product;

    private int quantity;

    // Getters and Setters
    public Long getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(Long orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
