package com.mobile.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mobile.demo.entity.Product;
import com.mobile.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	public List<Product> getAllProducts(@RequestBody Product product){
		return productRepository.findAll();
	}
	
//	public void deleteProduct(@PathVariable Long productid) {
//		productRepository.deleteById(productid);
//	}
	
	public Product getProductById(@PathVariable Long productid) {
		return productRepository.findById(productid).orElse(null);
	}
	
	public void deleteById(Long productid) {
        productRepository.deleteById(productid);
    }
	
//	 @Transactional
//	    public Product updateProductQuantity(Long productId, int quantity) {
//	        Product product = getProductById(productId);
//	        product.setStockQuantity(quantity);
//	        return productRepository.save(product);
//	    }
	@Transactional
	public Product updateProductQuantity(Long productId, int quantity) {
	    Product product = productRepository.findById(productId)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    product.setStockQuantity(product.getStockQuantity() + quantity); // Add to the existing quantity
	    return productRepository.save(product);
	}

	
	
}
