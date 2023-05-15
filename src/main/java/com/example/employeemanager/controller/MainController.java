package com.example.employeemanager.controller;

import com.example.employeemanager.MainApplication;
import com.example.employeemanager.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Collections;
import java.util.Comparator;

public class MainController {
    public Label balance;
    @FXML
    private TableView<MoneyManagement> tableView;
    @FXML
    private TableColumn<MoneyManagement, Integer> typeColum;
    @FXML
    private TableColumn<MoneyManagement, Integer> amountMoneyColum;
    @FXML
    private TableColumn<MoneyManagement, String> descriptionColum;
    @FXML
    private TableColumn<MoneyManagement, String> fechaColum;
    private MoneyList moneyList;
    private MoneyList tempMoneyList;

    public void initialize(MoneyList moneyList) {
        this.moneyList = moneyList;
        this.tempMoneyList = new MoneyList();
        tableView.setItems(tempMoneyList.getMoney());
    }

    public void onAddFinances(ActionEvent event) {
        sortByDate();
        FXMLLoader loader = MainApplication.renderView("add-finace-view.fxml");
        AddFinanceController addFinanceController = loader.getController();
        addFinanceController.setMoneyList(this.moneyList);
    }

    public void onClickViewSpent(ActionEvent event){
        balance.setText(calculateBalance());
        sortByDate();
        this.tempMoneyList = this.moneyList;
        AddFinanceController controller = new AddFinanceController();
        controller.setMoneyList(this.tempMoneyList);
        this.tempMoneyList = controller.getMoneyListSpentOnly();
        printTableView(this.tempMoneyList);
        tableView.setVisible(true);
    }

    public void onClickViewIncome(ActionEvent event){
        balance.setText(calculateBalance());
        sortByDate();
        this.tempMoneyList = this.moneyList;
        AddFinanceController controller = new AddFinanceController();
        controller.setMoneyList(this.tempMoneyList);
        this.tempMoneyList = controller.getMoneyListIncomeOnly();
        printTableView(this.tempMoneyList);
        tableView.setVisible(true);
    }

    public void onClickViewBoth(ActionEvent event){
        balance.setText(calculateBalance());
        sortByDate();
        this.tempMoneyList = moneyList;
        printTableView(this.tempMoneyList);
        tableView.setVisible(true);
    }

    public void printTableView(MoneyList moneyList){
        this.fechaColum.setCellValueFactory(new PropertyValueFactory<>("date"));
        typeColum.setCellValueFactory(new PropertyValueFactory<>("type"));
        descriptionColum.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountMoneyColum.setCellValueFactory(new PropertyValueFactory<>("valor"));

        this.tableView.setItems(null);
        this.tableView.layout();
        this.tableView.setItems(moneyList.getMoney());
        System.out.println(tableView);
    }

    public void sortByDate(){
        Collections.sort(this.moneyList.getMoney() , new Comparator<>() {
            @Override
            public int compare(MoneyManagement p1, MoneyManagement p2) {
                if (p1.getDate().compareTo(p2.getDate()) > 0) {
                    return -1;
                } else if (p1.getDate().compareTo(p2.getDate()) < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public String calculateBalance(){
        int totalSpent = 0;
        int totalIncome= 0;
        String balance;
        for (MoneyManagement moneyManagement: this.moneyList.getMoney()) {
            if(moneyManagement.getType()== 1){
                totalSpent+= moneyManagement.getValor();
            }else {
                totalIncome+=moneyManagement.getValor();
            }
        }
        balance = totalSpent-totalIncome + "";
        return balance;
    }

}
