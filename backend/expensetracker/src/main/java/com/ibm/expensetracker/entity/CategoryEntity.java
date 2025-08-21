package com.ibm.expensetracker.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="category")
public class CategoryEntity {


	@Id     //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //auto increment
	private Long categoryId;

	@Column(length = 100)
	private String categoryName;

	@OneToMany(mappedBy = "category" )
	private List<ExpenseEntity> expense;

	public CategoryEntity() {
	
	}

	public CategoryEntity(Long categoryId, String categoryName, List<ExpenseEntity> expense) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.expense = expense;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ExpenseEntity> getExpense() {
		return expense;
	}

	public void setExpense(List<ExpenseEntity> expense) {
		this.expense = expense;
	}
	
	

}
