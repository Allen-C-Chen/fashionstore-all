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

import com.smoothstack.fs.entity.Cart;
import com.smoothstack.fs.service.CartService;

@RestController
@RequestMapping(value = "/fs/tempcart")
public class CartController {
	@Autowired
	private CartService cartService;
	// Create a new Note
	@GetMapping(value = "/carts" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Cart>> getAllCarts() {
		return cartService.getAllCarts();
	}
	@PostMapping(value = "/cart",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Cart> createCart(@Valid @RequestBody Cart cart) {
				return cartService.createNewCart(cart);
	}
	@GetMapping(path = "/cart/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Cart> getCartByID(@PathVariable Integer id) {
		return cartService.getCartById(id);
	}
	
	@PutMapping(value = "/cart/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Cart> updateCart(
			@PathVariable Integer id,
			@Valid @RequestBody Cart cart) {
		return cartService.updateCart(id, cart);
	}
	@DeleteMapping(value = "/cart/{id}") //D
	public ResponseEntity<Cart> deleteCart(@PathVariable Integer id){
		return cartService.deleteCart(id);
	}
	
}
