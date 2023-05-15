package com.example.employeemanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SpentList {

    private ObservableList<Spent> spent;

    public SpentList() {
        spent = FXCollections.observableArrayList();
    }

    public ObservableList<Spent> getSpent() {
        return spent;
    }

    public void addSpent(Spent spent) {
        this.spent.add(spent);
    }

    public void updateSpent(int index, Spent spent) {
        this.spent.set(index, spent);
    }

    public void deleteSpent(Spent spent) {
        this.spent.remove(spent);
    }
}
