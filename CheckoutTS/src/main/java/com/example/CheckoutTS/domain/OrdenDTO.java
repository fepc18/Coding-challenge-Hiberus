package com.example.CheckoutTS.domain;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrdenDTO {
    private int clientId;
    private Date date;
    private String direction;
    public int getClientId() {
        return clientId;
    }

    public Date getDate() {
        return date;
    }

    public String getDirection() {
        return direction;
    }
    public List<productsDTO> getProducts() {
        return products;
    }
   /* public String getProductsToString() {
        return new Gson().toJson(products);
    }*/

    private List<productsDTO> products;

    public OrdenDTO(int clientId, Date date, String direction, List<productsDTO> products) {
        this.clientId = clientId;
        this.date = date;
        this.direction = direction;
        this.products = products;
    }


    public boolean modelIsValid(){
        Optional<List<productsDTO>> listOfProducts = Optional.ofNullable(products);
        int size = listOfProducts.map(List::size).orElse(0);
        return size>0;
    }

}
