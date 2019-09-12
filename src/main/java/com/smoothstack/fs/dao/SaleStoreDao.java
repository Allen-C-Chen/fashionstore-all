package com.smoothstack.fs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.fs.entity.SaleStore;
@Repository
public interface SaleStoreDao extends JpaRepository<SaleStore, Integer> {
}