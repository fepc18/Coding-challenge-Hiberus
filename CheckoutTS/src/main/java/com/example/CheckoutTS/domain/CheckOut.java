package com.example.CheckoutTS.domain;

import org.springframework.data.annotation.Id;

import com.google.gson.Gson;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CheckOut implements Serializable {

    @Id
    private String id;
    private int clientId;



    private Date date;
    private String direction;
    private List<productsDTO> products;
    private String billResult;
    public void setBillResult(String billResult) {
        this.billResult = billResult;
    }
    public String getId() {
        return id;
    }
    public CheckOut(int clientId, Date date, String direction, List<productsDTO> products) {
        generateId();
        this.clientId = clientId;
        this.date = date;
        this.direction = direction;
        this.products = products;
        this.billResult = "";

    }
    public CheckOut(){}

    public void generateId(){
        id= java.util.UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }
}
