package com.mobile.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.demo.dto.UpdateQuantityRequest;
import com.mobile.demo.entity.Product;
import com.mobile.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//adding the product to the database
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	//Getting all products
	@GetMapping
	public List<Product> getAllProducts(@RequestBody Product product){
		return productService.getAllProducts(product);
	}

	//Getting a product by productId
	@GetMapping("/{productid}")
	public Product getProductById(@PathVariable Long productid) {
		return productService.getProductById(productid);
	}
	
	
	//Add quantity of the product to the database
	 @PutMapping("/{productId}/quantity")
	    public Product updateProductQuantity(@PathVariable Long productId, @RequestBody UpdateQuantityRequest request) {
	        return productService.updateProductQuantity(productId, request.getQuantity());
	    }
	
	
	
	
	
	
	
}
