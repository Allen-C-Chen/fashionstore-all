package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.smoothstack.fs.dao.SaleStoreDao;
import com.smoothstack.fs.entity.SaleStore;
@Service
public class SaleStoreService {
	@Autowired
	private SaleStoreDao saleStoreDao; 
	
	
	@Transactional
	public ResponseEntity<List<SaleStore>> getAllSaleStores() {
		List<SaleStore> saleStores = saleStoreDao.findAll();
		return new ResponseEntity<List<SaleStore>>(saleStores, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<SaleStore> createNewSaleStore(SaleStore newSaleStore) {
		try {
			SaleStore saleStore =  saleStoreDao.save(newSaleStore);
			return new ResponseEntity<SaleStore>(saleStore, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<SaleStore>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<SaleStore> getSaleStoreById(int id) {
		try {
			SaleStore saleStore = saleStoreDao.findById(id).get();
			return new ResponseEntity<SaleStore>(saleStore, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<SaleStore>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<SaleStore> updateSaleStore(int id, SaleStore newSaleStore) {
		try {
			SaleStore saleStore = saleStoreDao.findById(id).get();
			if(saleStore == null) {
			    return new ResponseEntity<SaleStore>(HttpStatus.NOT_FOUND); //404
			}
			newSaleStore.setSalesStoreId(id);
			saleStoreDao.save(newSaleStore);
			return new ResponseEntity<SaleStore>(newSaleStore, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<SaleStore>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<SaleStore> deleteSaleStore(int id) {
		try {
			SaleStore saleStore = saleStoreDao.findById(id).get();
			saleStoreDao.delete(saleStore);
			return new ResponseEntity<SaleStore>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<SaleStore>( HttpStatus.NOT_FOUND);
		}
	}
}
