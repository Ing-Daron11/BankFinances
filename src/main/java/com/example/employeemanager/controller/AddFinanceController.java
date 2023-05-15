package com.example.employeemanager.controller;

import com.example.employeemanager.model.Income;
import com.example.employeemanager.model.IncomeList;
import com.example.employeemanager.model.Spent;
import com.example.employeemanager.model.SpentList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddFinanceController {

    @FXML
    private TextField amountMoneyTf;

    @FXML
    private TextField descriptionTf;

    private IncomeList incomeList;
    private SpentList spentList;

    public void setFinaceList(IncomeList incomeList, SpentList spentList){ //Herencia
        this.incomeList = incomeList;
        this.spentList = spentList;
    }

    @FXML
    public void onAddIncome(ActionEvent event) {
        String amountMoney = amountMoneyTf.getText();
        String descriptionText = descriptionTf.getText();
        try {
            int amountMoneyInteger = Integer.parseInt(amountMoney);
            Income newIncome = new Income(descriptionText, amountMoneyInteger);
            incomeList.addIncome(newIncome);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar el Ingreso");
            alert.setContentText("Debe ser un numero entero");
            alert.showAndWait();
        }
    }
    @FXML
    public void onAddSpent(ActionEvent event) {
        String amountMoney = amountMoneyTf.getText();
        String descriptionText = descriptionTf.getText();
        try {
            int amountMoneyInteger = Integer.parseInt(amountMoney);
            Spent newSpent = new Spent(descriptionText, amountMoneyInteger);//
            

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar el Gasto");
            alert.setContentText("Debe ser un numero entero");
            alert.showAndWait();
        }
    }

    @FXML
    public void onClose(ActionEvent event) {
        Stage stage = (Stage) amountMoneyTf.getScene().getWindow();
        stage.close();
    }


}
