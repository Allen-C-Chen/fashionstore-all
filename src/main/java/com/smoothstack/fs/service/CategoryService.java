package com.smoothstack.fs.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.fs.dao.CategoryDao;
import com.smoothstack.fs.entity.Category;
@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	@Transactional
	public ResponseEntity<List<Category>> getAllCategorys() {
		System.out.println(categoryDao.findAll());
		List<Category> categorys = categoryDao.findAll();
		return new ResponseEntity<List<Category>>(categorys, HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Category> createNewCategory(Category newCategory) {
		try {
			Category category =  categoryDao.save(newCategory);
			return new ResponseEntity<Category>(category, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Category> getCategoryById(int id) {
		try {
			Category category = categoryDao.findById(id).get();
			return new ResponseEntity<Category>(category, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Category>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Category> updateCategory(int id, Category newCategory) {
		try {
			Category category = categoryDao.findById(id).get();
			if(category == null) {
			    return new ResponseEntity<Category>(HttpStatus.NOT_FOUND); //404
			}
			newCategory.setGroupId(id);
			categoryDao.save(newCategory);
			return new ResponseEntity<Category>(newCategory, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Category>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Category> deleteCategory(int id) {
		try {
			Category category = categoryDao.findById(id).get();
			categoryDao.delete(category);
			return new ResponseEntity<Category>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Category>( HttpStatus.NOT_FOUND);
		}
	}
}
