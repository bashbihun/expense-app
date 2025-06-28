package com.poso.space.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poso.space.expense.dto.ExpenseDTO;
import com.poso.space.expense.entity.Expense;
import com.poso.space.expense.service.ExpenseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        Expense savExpense = expenseService.creatExpense(expenseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savExpense);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense() {
        List<Expense> listExpenses = expenseService.getAllExpense();
        return ResponseEntity.ok(listExpenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDTO expenseDTO) {
        Expense updated = expenseService.updateExpense(id, expenseDTO);
        return ResponseEntity.ok(updated);
    }
}
