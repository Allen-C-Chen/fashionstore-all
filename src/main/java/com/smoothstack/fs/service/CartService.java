package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.fs.dao.CartDao;
import com.smoothstack.fs.entity.Cart;
import com.smoothstack.fs.entity.Product;
@Service
public class CartService {
	private CartDao cartDao;
	@Transactional
	public ResponseEntity<List<Cart>> getAllCarts() {
		List<Cart> carts = cartDao.findAll();
		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Cart> createNewCart(Cart newCart) {
		try {
			Cart cart =  cartDao.save(newCart);
			return new ResponseEntity<Cart>(cart, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Cart>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<List<Product>> getProductByCartId(int cartId) {
		try {
			Optional<List<Product>> products = cartDao.displayProducstByCartId(cartId);
			return new ResponseEntity<List<Product>>(products.get(), HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional
	public ResponseEntity<Cart> getCartById(int id) {
		try {
			Cart cart = cartDao.findById(id).get();
			return new ResponseEntity<Cart>(cart, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Cart>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Cart> updateCart(int id, Cart newCart) {
		try {
			Cart cart = cartDao.findById(id).get();
			if(cart == null) {
			    return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND); //404
			}
			newCart.setCartId(id);
			cartDao.save(newCart);
			return new ResponseEntity<Cart>(newCart, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Cart>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Cart> deleteCart(int id) {
		try {
			Cart cart = cartDao.findById(id).get();
			cartDao.delete(cart);
			return new ResponseEntity<Cart>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Cart>( HttpStatus.NOT_FOUND);
		}
	}
}
