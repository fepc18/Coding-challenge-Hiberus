package com.example.BillMS.controller;

import com.example.BillMS.domain.Bill;
import com.example.BillMS.domain.CheckOut;
import com.example.BillMS.infrastructure.BillRepository;
import com.example.BillMS.service.BillService;
import com.example.BillMS.service.IBillService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
@Component
public class BillMSReceiver {
    @Autowired
    private IBillService billService;

    private CountDownLatch latch = new CountDownLatch(1);

    public BillMSReceiver(BillRepository billRepository) {
        this.billService = new BillService(billRepository);
    }

    public void receiveMessage(String message) throws JsonProcessingException {
        System.out.println("Bill Received <" + message + ">");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CheckOut checkOut = objectMapper.readValue(message, CheckOut.class);
        System.out.println("Message Deserialized <" + checkOut.getId() + ">");

        Bill billResult = billService.createBill(checkOut);
        System.out.println("Bill Create <" + billResult.getId() + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
