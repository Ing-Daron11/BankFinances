package com.example.employeemanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IncomeList {

    private ObservableList<Income> incomes;

    public IncomeList() {
        incomes = FXCollections.observableArrayList();
    }

    public ObservableList<Income> getIncomes() {
        return incomes;
    }

    public void addIncome(Income income) {
        this.incomes.add(income);
    }

    public void updateIncome(int index, Income income) {
        this.incomes.set(index, income);
    }

    public void deleteIncome(Income income) {
        this.incomes.remove(income);
    }
}
