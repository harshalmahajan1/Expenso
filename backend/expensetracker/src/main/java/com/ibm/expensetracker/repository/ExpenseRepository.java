package com.ibm.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.expensetracker.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

	@Query("Select e FROM ExpenseEntity e ORDER BY e.amount desc LIMIT 1")
	public ExpenseEntity findMaxAmountExpense();
	
	@Query("Select e FROM ExpenseEntity e ORDER BY e.amount desc")
	public List<ExpenseEntity> findAmountExpenseDataByDescOrd();
}
