package com.example.employeemanager.controller;

import com.example.employeemanager.MainApplication;
import com.example.employeemanager.model.Income;
import com.example.employeemanager.model.IncomeList;
import com.example.employeemanager.model.Spent;
import com.example.employeemanager.model.SpentList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    private TableView<Income> tableView; //Herencia
    @FXML
    private TableColumn<Income, Integer> ingresos;
    @FXML
    private TableColumn<Spent, Integer> gastos;
    @FXML
    private TableColumn<Income, Integer> balance;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private IncomeList incomeList;
    private SpentList spentList;

    public void initialize(IncomeList incomeList, SpentList spentList) { //Hay que aplicar herencia una clase que una a Spent y Income
        this.incomeList = incomeList; //Herencia
        this.spentList = spentList; //Herencia

        ingresos.setCellValueFactory(new PropertyValueFactory<>("amountOfMoney"));
        gastos.setCellValueFactory(new PropertyValueFactory<>(""));
        balance.setCellValueFactory(new PropertyValueFactory<>(""));

        System.out.println(tableView);
        tableView.setItems(
                incomeList.getIncomes()
        );
    }

    public void onAddFinances(ActionEvent event) {
        FXMLLoader loader = MainApplication.renderView("add-finace-view.fxml");
        AddFinanceController addFinanceController = loader.getController();
        addFinanceController.setFinaceList(this.incomeList);//Herencia
        editButton.setDisable(false);
    }

}
