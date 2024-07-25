package com.mobile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
