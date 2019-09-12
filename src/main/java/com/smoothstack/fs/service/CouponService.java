package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.smoothstack.fs.dao.CouponDao;
import com.smoothstack.fs.entity.Coupon;
@Service
public class CouponService {
	@Autowired
	private CouponDao couponDao; 
	
	
	@Transactional
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		List<Coupon> coupons = couponDao.findAll();
		return new ResponseEntity<List<Coupon>>(coupons, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Coupon> createNewCoupon(Coupon newCoupon) {
		try {
			Coupon coupon =  couponDao.save(newCoupon);
			return new ResponseEntity<Coupon>(coupon, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Coupon>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Coupon> getCouponById(int id) {
		try {
			Coupon coupon = couponDao.findById(id).get();
			return new ResponseEntity<Coupon>(coupon, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Coupon>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Coupon> updateCoupon(int id, Coupon newCoupon) {
		try {
			Coupon coupon = couponDao.findById(id).get();
			if(coupon == null) {
			    return new ResponseEntity<Coupon>(HttpStatus.NOT_FOUND); //404
			}
			newCoupon.setCouponId(id);
			couponDao.save(newCoupon);
			return new ResponseEntity<Coupon>(newCoupon, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Coupon>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Coupon> deleteCoupon(int id) {
		try {
			Coupon coupon = couponDao.findById(id).get();
			couponDao.delete(coupon);
			return new ResponseEntity<Coupon>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Coupon>( HttpStatus.NOT_FOUND);
		}
	}
}
