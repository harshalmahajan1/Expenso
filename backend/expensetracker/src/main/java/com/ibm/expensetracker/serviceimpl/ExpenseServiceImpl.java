package com.ibm.expensetracker.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.expensetracker.entity.ExpenseEntity;
import com.ibm.expensetracker.repository.ExpenseRepository;
import com.ibm.expensetracker.service.ExpenseService;

@Component
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	public ExpenseRepository expenseRepository;

	@Override
	public void saveExpenseData(ExpenseEntity expenseData) {
		expenseRepository.save(expenseData);
	}

	@Override
	public List<ExpenseEntity> getAllExpenses() {
		List<ExpenseEntity> expenseDataList = expenseRepository.findAll();
		return expenseDataList;
	}

	@Override
	public ExpenseEntity getExpenseDataById(Long expenseId) {
		Optional<ExpenseEntity> expenseDataOptional = expenseRepository.findById(expenseId);
		if (expenseDataOptional.isPresent()) {
			return expenseDataOptional.get();
		} else {
			return null;
		}

	}

	@Override
	public void deleteExpenseById(Long expenseId) {
		expenseRepository.deleteById(expenseId);
	}

	@Override
	public void updateExpenseData(ExpenseEntity expenseData) {
		expenseRepository.save(expenseData);
	}

	@Override
	public ExpenseEntity findMaxAmountExpense() {
		return expenseRepository.findMaxAmountExpense();

	}

	@Override
	public void pachExpenseUpdate(Long id, ExpenseEntity expenseData) {
		Optional<ExpenseEntity> expenseDetails = expenseRepository.findById(id);
		if (expenseDetails.isPresent()) {
			ExpenseEntity expense = expenseDetails.get();

			if (expenseData.getAmount() != null && expenseData.getAmount() != 0) {
				expense.setAmount(expenseData.getAmount());
			}
			if (expenseData.getTitle() != null) {
				expense.setTitle(expenseData.getTitle());
			}
			if (expenseData.getDescription() != null) {
				expense.setDescription(expenseData.getDescription());
			}

			expenseRepository.save(expense);

		}

	}

}
