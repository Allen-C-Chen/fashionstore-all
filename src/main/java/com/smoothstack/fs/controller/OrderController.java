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

import com.smoothstack.fs.entity.Order;
import com.smoothstack.fs.service.OrderService;

@RestController
@RequestMapping(value = "/fs/temporder")
public class OrderController {
	@Autowired
	private OrderService orderService;
	// Create a new Note
	@GetMapping(value = "/orders" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Order>> getAllOrders() {
		return orderService.getAllOrders();
	}
	@PostMapping(value = "/order",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
				return orderService.createNewOrder(order);
	}
	@GetMapping(path = "/order/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Order> getOrderByID(@PathVariable Integer id) {
		return orderService.getOrderById(id);
	}
	
	@PutMapping(value = "/order/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Order> updateOrder(
			@PathVariable Integer id,
			@Valid @RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}
	@DeleteMapping(value = "/order/{id}") //D
	public ResponseEntity<Order> deleteOrder(@PathVariable Integer id){
		return orderService.deleteOrder(id);
	}
	/*
	 * @PostMapping(value = "/cart/{cartId}/products/add", consumes =
	 * {"application/json", "application/xml"}, produces = {"application/json",
	 * "application/xml"})//C public ResponseEntity<Order> addOrderToCart(
	 * 
	 * @PathVariable Integer cartId,
	 * 
	 * @Valid @RequestBody Order newOrder) { newOrder.getCart().setCartId(cartId);
	 * return orderService.createNewOrder(newOrder); }
	 */
}
