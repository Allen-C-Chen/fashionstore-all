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

import com.smoothstack.fs.entity.Coupon;
import com.smoothstack.fs.service.CouponService;

@RestController
@RequestMapping(value = "/fs/tempcoup")
public class CouponController {
	@Autowired
	private CouponService couponService;
	// Create a new Note
	@GetMapping(value = "/coupons" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		return couponService.getAllCoupons();
	}
	@PostMapping(value = "/coupon",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Coupon> createCoupon(@Valid @RequestBody Coupon coupon) {
				return couponService.createNewCoupon(coupon);
	}
	@GetMapping(path = "/coupon/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Coupon> getCouponByID(@PathVariable Integer id) {
		return couponService.getCouponById(id);
	}
	
	@PutMapping(value = "/coupon/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Coupon> updateCoupon(
			@PathVariable Integer id,
			@Valid @RequestBody Coupon coupon) {
		return couponService.updateCoupon(id, coupon);
	}
	@DeleteMapping(value = "/coupon/{id}") //D
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable Integer id){
		return couponService.deleteCoupon(id);
	}
	
}
