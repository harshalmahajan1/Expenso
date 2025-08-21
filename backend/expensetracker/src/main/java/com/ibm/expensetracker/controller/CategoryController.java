package com.ibm.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.expensetracker.entity.CategoryEntity;
import com.ibm.expensetracker.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save-category")
	public ResponseEntity<String> saveCategories(@RequestBody CategoryEntity categoryEntity){
		categoryService.saveCategory(categoryEntity);
		return new ResponseEntity<>("Category Saved Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-categories")
	public  ResponseEntity<List<CategoryEntity>> getAllCategories(){
		List<CategoryEntity> categoryList =categoryService.getAllCategories();
		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}

	
}
