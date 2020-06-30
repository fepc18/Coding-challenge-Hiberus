package com.example.BillMS.domain;

import org.springframework.data.annotation.Id;

import com.google.gson.Gson;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CheckOut implements Serializable {

    @Id
    private String id;
    private int clientId;
    private String date;
    private String direction;
    private List<productsDTO> products;
    private String billResult;
    private String logisticResult;

    public String getId() {
        return id;
    }
    public int getClientId() {
        return clientId;
    }

    public String getDate() {
        return date;
    }

    public List<productsDTO> getProducts() {
        return products;
    }
    public CheckOut(int clientId, String date, String direction, List<productsDTO> products) {
        generateId();
        this.clientId = clientId;
        this.date = date;
        this.direction = direction;
        this.products = products;
        this.billResult = "";
        this.logisticResult = "";
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
