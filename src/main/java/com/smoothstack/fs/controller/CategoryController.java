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

import com.smoothstack.fs.entity.Category;
import com.smoothstack.fs.service.CategoryService;

@RestController
@RequestMapping(value = "/fs/tempcat")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	// Create a new Note
	@GetMapping(value = "/categorys" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Category>> getAllCategorys() {
		return categoryService.getAllCategorys();
	}
	@PostMapping(value = "/category",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
				return categoryService.createNewCategory(category);
	}
	@GetMapping(path = "/category/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Category> getCategoryByID(@PathVariable Integer id) {
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping(value = "/category/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Category> updateCategory(
			@PathVariable Integer id,
			@Valid @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}
	@DeleteMapping(value = "/category/{id}") //D
	public ResponseEntity<Category> deleteCategory(@PathVariable Integer id){
		return categoryService.deleteCategory(id);
	}
	
}
