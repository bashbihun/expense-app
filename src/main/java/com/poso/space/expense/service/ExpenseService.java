package com.poso.space.expense.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
}
