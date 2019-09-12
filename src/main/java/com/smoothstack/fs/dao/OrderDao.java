package com.smoothstack.fs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.fs.entity.Order;
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}