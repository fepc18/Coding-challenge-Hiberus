package com.example.BillMS.domain;

import com.google.gson.Gson;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Bill {

    @Id
    private String id;
    private String checkOutId;
    private int clientId;
    private String date;
    private double sum;

    public String getCheckOutId() {
        return checkOutId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getDate() {
        return date;
    }

    public double getSum() {
        return sum;
    }

    public String getId() {
        return id;
    }
    public Bill(String checkOutId,int clientId, String date, List<productsDTO> products) {
        generateId();
        this.checkOutId = checkOutId;
        this.clientId = clientId;
        this.date = date;
        sumProducts(products);
    }

    public Bill() {

    }

    private void sumProducts(List<productsDTO> products){
        sum = products.stream()
                .mapToDouble(a -> a.getCost())
                .sum();
    }

    public void generateId(){
        id= java.util.UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }

}
