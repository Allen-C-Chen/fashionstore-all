package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.smoothstack.fs.dao.CustomerDao;
import com.smoothstack.fs.entity.Customer;
@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao; 
	
	
	@Transactional
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerDao.findAll();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Customer> createNewCustomer(Customer newCustomer) {
		try {
			Customer coupon =  customerDao.save(newCustomer);
			return new ResponseEntity<Customer>(coupon, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Customer> getCustomerById(int id) {
		try {
			Customer coupon = customerDao.findById(id).get();
			return new ResponseEntity<Customer>(coupon, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Customer>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Customer> updateCustomer(int id, Customer newCustomer) {
		try {
			Customer customer = customerDao.findById(id).get();
			if(customer == null) {
			    return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND); //404
			}
			newCustomer.setCustomerId(id);
			customerDao.save(newCustomer);
			return new ResponseEntity<Customer>(newCustomer, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Customer>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Customer> deleteCustomer(int id) {
		try {
			Customer coupon = customerDao.findById(id).get();
			customerDao.delete(coupon);
			return new ResponseEntity<Customer>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Customer>( HttpStatus.NOT_FOUND);
		}
	}
}
