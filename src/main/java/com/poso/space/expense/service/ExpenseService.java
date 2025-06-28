package com.poso.space.expense.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.poso.space.expense.dto.ExpenseDTO;
import com.poso.space.expense.entity.Expense;
import com.poso.space.expense.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public Expense creatExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        BeanUtils.copyProperties(expenseDTO, expense);
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
    }

    public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

        existing.setTitle(expenseDTO.getTitle());
        existing.setAmount(expenseDTO.getAmount());
        existing.setCategory(expenseDTO.getCategory());
        existing.setDate(expenseDTO.getDate());
        return expenseRepository.save(existing);
    }
}
