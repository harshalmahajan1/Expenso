package com.ibm.expensetracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.expensetracker.entity.CategoryEntity;

@Service
public interface CategoryService {

	public void saveCategory(CategoryEntity categoryData);
	
	public List<CategoryEntity> getAllCategories();
}
