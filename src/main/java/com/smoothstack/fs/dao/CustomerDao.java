package com.smoothstack.fs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.fs.entity.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}