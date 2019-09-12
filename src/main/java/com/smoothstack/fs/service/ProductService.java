package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.fs.dao.ProductDao;
import com.smoothstack.fs.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Transactional
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productDao.findAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Product> createNewProduct(Product newProduct) {
		try {
			Product product =  productDao.save(newProduct);
			return new ResponseEntity<Product>(product, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Product> getProductById(int id) {
		try {
			Product product = productDao.findById(id).get();
			return new ResponseEntity<Product>(product, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<List<Product>> getProductByGender(String gender) {
		try {
			Optional<List<Product>> products = productDao.findByGender(gender);
			return new ResponseEntity<List<Product>>(products.get(), HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Product> updateProduct(int id, Product newProduct) {
		try {
			Product product = productDao.findById(id).get();
			if(product == null) {
			    return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); //404
			}
			newProduct.setProductId(id);
			productDao.save(newProduct);
			return new ResponseEntity<Product>(newProduct, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<List<Product>> getProductByCartId(int cartId) {
		try {
			Optional<List<Product>> products = productDao.displayProdcutsByCartId(cartId);
			return new ResponseEntity<List<Product>>(products.get(), HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Product> deleteProduct(int id) {
		try {
			Product product = productDao.findById(id).get();
			productDao.delete(product);
			return new ResponseEntity<Product>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
		}
	}
}
