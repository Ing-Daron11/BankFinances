package com.example.employeemanager.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MoneyManagement {

    private String description;
    private int valor;
    private int type;
    private Date date;
    private String fecha;

    public MoneyManagement(String description, int valor, int type, Date date) {
        this.description = description;
        this.valor = valor;
        this.type = type;
        this.date = date;
        Calendar dateWithHour = Calendar.getInstance();

        dateWithHour.clear(Calendar.HOUR_OF_DAY);
        dateWithHour.clear(Calendar.MINUTE);
        dateWithHour.clear(Calendar.SECOND);
        dateWithHour.clear(Calendar.MILLISECOND);
        SimpleDateFormat formatedDate = new SimpleDateFormat("dd/MM/yyyy");
        this.fecha = formatedDate.format(date) +"";
    }

    //-----------------Getters and setters----------------------------
    public int getValor() {
        return valor;
    }

    public int getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


