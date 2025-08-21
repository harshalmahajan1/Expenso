package com.ibm.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.expensetracker.entity.ExpenseEntity;
import com.ibm.expensetracker.service.ExpenseService;
/**
 * Rest controller calls for expense data handling
 * @author Shubham
 *
 */
@RestController
@RequestMapping("/expense")
@CrossOrigin
public class ExpenseController {

	@Autowired
	public ExpenseService expenseService;

	/**
	 * This is api for saving expense data
	 * @param expenseData
	 * @return
	 */
	@PostMapping("/save-expense")
	public ResponseEntity<String> saveExpenseData(@RequestBody ExpenseEntity expenseData) {
		expenseService.saveExpenseData(expenseData);
		return new ResponseEntity<>("Expense Saved Successfuly", HttpStatus.CREATED);

	}

	/**
	 * api for get all expense data
	 * @return all expense data
	 */
	@GetMapping("/get-all-expenses")
	public ResponseEntity<List<ExpenseEntity>> getAllExpanses() {
		List<ExpenseEntity> expenseDataList = expenseService.getAllExpenses();
		return new ResponseEntity<>(expenseDataList, HttpStatus.OK);
	}

	/**
	 * api for get expense data by id
	 * @param expenseId
	 * @return
	 */
	@GetMapping("/get-expense/{expenseId}")
	public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long expenseId) {
		ExpenseEntity expenseData = expenseService.getExpenseDataById(expenseId);
		return new ResponseEntity<>(expenseData, HttpStatus.OK);

	}
	/**
	 * this api is for delete expense
	 * @param id
	 * @return
	 */

	@DeleteMapping("/delete-expense")
	public ResponseEntity<String> deleteExpenseById(@RequestParam Long id) {
		expenseService.deleteExpenseById(id);
		return new ResponseEntity<>("Expense Data Deleted Successfuly", HttpStatus.NO_CONTENT);
	}

	
	/**
	 * api for updatingbexpense data
	 * @param expenseData
	 * @return
	 */
	@PutMapping("/update-expense")
	public ResponseEntity<String> updateExpenseData(@RequestBody ExpenseEntity expenseData) {
		expenseService.updateExpenseData(expenseData);
		return new ResponseEntity<>("Expense Data Updated Successfuly", HttpStatus.OK);

	}

	/**
	 * Api to get max amount from table
	 * @return
	 */
	@GetMapping("/max-amount")
	public ResponseEntity<ExpenseEntity> findMaxAmountExpense() {
		ExpenseEntity maxExp = expenseService.findMaxAmountExpense();
		return new ResponseEntity<>(maxExp, HttpStatus.OK);
	}

	/**
	 * api for partially update the data
	 * @param id
	 * @param expenseData
	 * @return
	 */
	@PatchMapping("/patch-expense/{id}")
	public ResponseEntity<String> expensePatchUpdate(@PathVariable Long id, @RequestBody ExpenseEntity expenseData) {
		expenseService.pachExpenseUpdate(id, expenseData);
		return new ResponseEntity<>("Expense Data Updated Successfuly", HttpStatus.OK);

	}

}
