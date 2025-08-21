package com.ibm.expensetracker.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.expensetracker.entity.CategoryEntity;
import com.ibm.expensetracker.repository.CategoryRepository;
import com.ibm.expensetracker.service.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void saveCategory(CategoryEntity categoryData) {
		categoryRepository.save(categoryData);
	}

	@Override
	public List<CategoryEntity> getAllCategories() {
		List<CategoryEntity> categoryData =categoryRepository.findAll();
		return categoryData;
	}

}
