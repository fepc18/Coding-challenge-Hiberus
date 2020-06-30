package com.example.LogisticMS.domain;

import org.springframework.data.annotation.Id;

import com.google.gson.Gson;


import java.io.Serializable;
import java.util.List;

public class CheckOut implements Serializable {

    @Id
    private String id;
    private int clientId;
    private String date;
    private String direction;
    private List<productsDTO> products;


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
        this.clientId = clientId;
        this.date = date;
        this.direction = direction;
        this.products = products;
    }
    public CheckOut(){}


    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }
}
