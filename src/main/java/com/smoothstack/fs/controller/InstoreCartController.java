package com.smoothstack.fs.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.fs.entity.Cart;
import com.smoothstack.fs.entity.Customer;
import com.smoothstack.fs.entity.Order;
import com.smoothstack.fs.entity.Product;
import com.smoothstack.fs.service.CartService;
import com.smoothstack.fs.service.OrderService;
import com.smoothstack.fs.service.ProductService;

@RestController
@RequestMapping(value = "/fashionstore/instore")

public class InstoreCartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

	@Autowired
	private CartService cartService;
	// Create a new Note
	@GetMapping(value = "/products" , 
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Product>> getAllProducts() { //list all the products
		return productService.getAllProducts();
	}

	@GetMapping(value = "/cart/{cartId}" , 
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Product>> getProductByCartId(@PathVariable Integer cartId) { //list all the products
		return productService.getProductByCartId(cartId);
	}
	@PostMapping(value = "/cart/{cartId}/products/add",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Order> addOrderToCart(
			@PathVariable Integer cartId,
			@Valid @RequestBody Order newOrder) {
		newOrder.getCart().setCartId(cartId);
		return orderService.createNewOrder(newOrder);
	}
	@DeleteMapping(value = "/cart/{cartId}/products/remove")
	public ResponseEntity<Order> deleteOrderFromCart(@PathVariable Integer cartId,
			@Valid @RequestBody Order order){
		
		return orderService.deleteOrder(order.getOrderId());
	}	
	@PutMapping(value = "/cart/{cartId}/products/update",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Order> updateOrderFromCart(
			@PathVariable Integer cartId,
			@Valid @RequestBody Order order) {
		return orderService.updateOrder(order.getOrderId(), order);
	}

}
