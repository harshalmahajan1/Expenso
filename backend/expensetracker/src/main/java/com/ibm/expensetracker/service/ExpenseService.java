package com.ibm.expensetracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.expensetracker.entity.ExpenseEntity;

@Service
public interface ExpenseService {

	public void saveExpenseData(ExpenseEntity expenseData);
	
	public List<ExpenseEntity> getAllExpenses();
	
	public ExpenseEntity getExpenseDataById(Long expenseId);
	
	public void deleteExpenseById(Long expenseId);
	
	public void updateExpenseData(ExpenseEntity expenseData);
	
	public ExpenseEntity findMaxAmountExpense();
	
	public void pachExpenseUpdate(Long id,ExpenseEntity expenseData);
}
