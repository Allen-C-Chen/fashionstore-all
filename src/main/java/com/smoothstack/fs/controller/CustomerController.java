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

import com.smoothstack.fs.entity.Customer;
import com.smoothstack.fs.service.CustomerService;

@RestController
@RequestMapping(value = "/fs/tempcus")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	// Create a new Note
	@GetMapping(value = "/customers" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	@PostMapping(value = "/customer",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
				return customerService.createNewCustomer(customer);
	}
	@GetMapping(path = "/customer/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Customer> getCustomerByID(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}
	
	@PutMapping(value = "/customer/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Customer> updateCustomer(
			@PathVariable Integer id,
			@Valid @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	@DeleteMapping(value = "/customer/{id}") //D
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id){
		return customerService.deleteCustomer(id);
	}
	
}
