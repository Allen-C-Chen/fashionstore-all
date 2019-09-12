package com.smoothstack.fs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.fs.entity.Category;;
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {


}
