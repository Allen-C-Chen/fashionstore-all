package com.smoothstack.fs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.fs.entity.Product;
import com.smoothstack.fs.service.ProductService;

@RestController
@RequestMapping(value = "/fs/tempprod")
public class ProductController {
	@Autowired
	private ProductService productService;
	// Create a new Note
	@GetMapping(value = "/products" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Product>> getAllProducts() {
		return productService.getAllProducts();
	}
	@GetMapping(value = "/products/{gender}" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Product>> getAllProductsByGender(
			@PathVariable String gender
			) {
		return productService.getProductByGender(gender);
	}
	@PostMapping(value = "/product",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
				return productService.createNewProduct(product);
	}
	@GetMapping(path = "/product/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Product> getProductByID(@PathVariable Integer id) {
		return productService.getProductById(id);
	}
	
	@PutMapping(value = "/product/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Product> updateProduct(
			@PathVariable Integer id,
			@Valid @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	@DeleteMapping(value = "/product/{id}") //D
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id){
		return productService.deleteProduct(id);
	}
	
}
