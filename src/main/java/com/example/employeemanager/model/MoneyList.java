package com.example.employeemanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MoneyList {

    private ObservableList<MoneyManagement> moneyManagements;

    public MoneyList() {
        moneyManagements = FXCollections.observableArrayList();
    }

    public ObservableList<MoneyManagement> getMoney() {
        return moneyManagements;
    }

    public void addMoneyManagment(MoneyManagement moneyManagement) {
        this.moneyManagements.add(moneyManagement);
    }

}
