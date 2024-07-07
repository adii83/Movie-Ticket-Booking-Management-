package com.mycompany.movieticketbookingmanagement.model;

import java.sql.Date;
import java.sql.Time;

public class CustomerData {

    private Integer id;
    private String title;
    private String type;
    private Integer quantity;
    private double total;
    private Date date;
    private Time time;


    public CustomerData(Integer id,String title, String type, Integer quantity, double total, Date date,Time time) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
        this.time = time;
    }
    public Integer getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getType(){
        return type;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public double getTotal(){
        return total;
    }
    public Date getDate(){
        return date;
    }
    public Time getTime(){
        return time;
    }

}
