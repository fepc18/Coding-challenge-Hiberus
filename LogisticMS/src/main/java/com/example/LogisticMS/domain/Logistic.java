package com.example.LogisticMS.domain;

import com.google.gson.Gson;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Logistic {

    @Id
    private String id;
    private String checkOutId;
    private int clientId;
    private List<productsDTO> products;

    public String getCheckOutId() {
        return checkOutId;
    }

    public int getClientId() {
        return clientId;
    }


    public String getId() {
        return id;
    }
    public Logistic(String checkOutId, int clientId, String date, List<productsDTO> products) {
        generateId();
        this.checkOutId = checkOutId;
        this.clientId = clientId;
        this.products = products;
    }

    public Logistic() {

    }

    public void generateId(){
        id= java.util.UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }

}
