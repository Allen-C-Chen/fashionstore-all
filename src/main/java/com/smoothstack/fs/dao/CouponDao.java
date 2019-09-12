package com.smoothstack.fs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.fs.entity.Coupon;

@Repository
public interface CouponDao extends JpaRepository<Coupon, Integer> {

}
