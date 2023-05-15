package com.example.employeemanager.model;

public class Spent {

    private String description;
    private int amountOfMoney;

    public Spent(String description, int amountOfMoney) {
        this.description = description;
        this.amountOfMoney = amountOfMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}


