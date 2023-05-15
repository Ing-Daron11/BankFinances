package com.example.employeemanager.controller;

import com.example.employeemanager.model.MoneyManagement;
import com.example.employeemanager.model.MoneyList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFinanceController {

    @FXML
    private TextField amountMoneyTf;

    @FXML
    private TextField descriptionTf;
    @FXML
    private TextField typeTf;
    @FXML
    private TextField fechaTf;

    private static MoneyList moneyList;

    @FXML
    public void onAddIncome(ActionEvent event) {
        String amountMoney = amountMoneyTf.getText();
        String descriptionText = descriptionTf.getText();
        String tipo = typeTf.getText();
        String fecha = fechaTf.getText();
        try {
            int amountMoneyInteger = Integer.parseInt(amountMoney);
            int tipoInteger = Integer.parseInt(tipo);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date= format.parse(fecha);
            MoneyManagement newMoneyManagement = new MoneyManagement(descriptionText, amountMoneyInteger, tipoInteger, date);
            moneyList.addMoneyManagment(newMoneyManagement);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Por favor oprima el botón *Both* para ver ambos (ingresos y gastos)" );
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar el monto");
            alert.setContentText("Debe ser un numero entero");
            alert.showAndWait();
        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar la fecha");
            alert.setContentText("Debe tener la siguiente forma 01/01/2023");
        }
    }
    @FXML
    public void onClose(ActionEvent event) {
        Stage stage = (Stage) amountMoneyTf.getScene().getWindow();
        stage.close();
    }

    //--------------------------Getters and setters---------------------------

    public static MoneyList getMoneyListSpentOnly(){
        MoneyList moneyList1=new MoneyList();
        for (MoneyManagement moneyManagement: moneyList.getMoney()
        ) {
            if(moneyManagement.getType() == 2){
                moneyList1.addMoneyManagment(moneyManagement);
            }
        }
        return moneyList1;
    }

    public static MoneyList getMoneyListIncomeOnly(){
        MoneyList moneyList2=new MoneyList();
        for (MoneyManagement moneyManagement: moneyList.getMoney()) {
            if(moneyManagement.getType() == 1){
                moneyList2.addMoneyManagment(moneyManagement);
            }
        }
        return moneyList2;
    }

    public static void setMoneyList(MoneyList moneyList2){
        moneyList = moneyList2;
    }


}
