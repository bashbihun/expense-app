package com.poso.space.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poso.space.expense.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
