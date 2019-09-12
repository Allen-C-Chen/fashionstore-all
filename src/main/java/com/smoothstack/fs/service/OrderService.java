package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.smoothstack.fs.dao.OrderDao;
import com.smoothstack.fs.entity.Order;
@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao; 
	
	
	@Transactional
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderDao.findAll();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Order> createNewOrder(Order newOrder) {
		try {
			Order author =  orderDao.save(newOrder);
			return new ResponseEntity<Order>(author, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Order> getOrderById(int id) {
		try {
			Order author = orderDao.findById(id).get();
			return new ResponseEntity<Order>(author, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Order>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Order> updateOrder(int id, Order newOrder) {
		try {
			Order order = orderDao.findById(id).get();
			if(order == null) {
			    return new ResponseEntity<Order>(HttpStatus.NOT_FOUND); //404
			}
			newOrder.setOrderId(id);
			orderDao.save(newOrder);
			return new ResponseEntity<Order>(newOrder, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Order>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Order> deleteOrder(int id) {
		try {
			Order author = orderDao.findById(id).get();
			orderDao.delete(author);
			return new ResponseEntity<Order>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Order>( HttpStatus.NOT_FOUND);
		}
	}
}
