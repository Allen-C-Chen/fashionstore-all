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

import com.smoothstack.fs.entity.SaleStore;
import com.smoothstack.fs.service.SaleStoreService;

@RestController
@RequestMapping(value = "/fs/tempSaleStore")
public class SaleStoreController {
	@Autowired
	private SaleStoreService saleStoreService;
	// Create a new Note
	@GetMapping(value = "/saleStores" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<SaleStore>> getAllSaleStores() {
		return saleStoreService.getAllSaleStores();
	}
	@PostMapping(value = "/saleStore",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<SaleStore> createSaleStore(@Valid @RequestBody SaleStore saleStore) {
				return saleStoreService.createNewSaleStore(saleStore);
	}
	@GetMapping(path = "/saleStore/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<SaleStore> getSaleStoreByID(@PathVariable Integer id) {
		return saleStoreService.getSaleStoreById(id);
	}
	
	@PutMapping(value = "/saleStore/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<SaleStore> updateSaleStore(
			@PathVariable Integer id,
			@Valid @RequestBody SaleStore saleStore) {
		return saleStoreService.updateSaleStore(id, saleStore);
	}
	@DeleteMapping(value = "/saleStore/{id}") //D
	public ResponseEntity<SaleStore> deleteSaleStore(@PathVariable Integer id){
		return saleStoreService.deleteSaleStore(id);
	}
	
}
