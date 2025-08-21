package com.ibm.expensetracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="expenses")
public class ExpenseEntity {

	@Id     //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //auto increment
	private Long id;
	
	@Column(name="title" , length = 100)
	private String title;
	
	@Column(name="amount",nullable = false)
	private Double amount;
	
	@Column(name="description", length = 200)
	private String description;
	
	@Column(name="date", nullable = false)
	private LocalDate date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id", referencedColumnName = "categoryId" )
	private CategoryEntity category;
	
	public ExpenseEntity() {
		
	}

	public ExpenseEntity(Long id, String title, Double amount, String description, LocalDate date,
			CategoryEntity category) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

//	public CategoryEntity getCategory() {
//		return category;
//	}
//
//	public void setCategory(CategoryEntity category) {
//		this.category = category;
//	}

	@Override
	public String toString() {
		return "ExpenseEntity [id=" + id + ", title=" + title + ", amount=" + amount + ", description=" + description
				+ ", date=" + date + ", category=" + category + "]";
	}

	
	
	
}
