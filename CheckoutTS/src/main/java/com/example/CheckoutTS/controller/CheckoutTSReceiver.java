package com.example.CheckoutTS.controller;

import com.example.CheckoutTS.domain.BillResultDto;
import com.example.CheckoutTS.infrastructure.CheckoutRepository;
import com.example.CheckoutTS.service.CheckoutService;
import com.example.CheckoutTS.service.ICheckoutService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
@Component
public class CheckoutTSReceiver {
    @Autowired
    private ICheckoutService checkoutService;
    private CountDownLatch latch = new CountDownLatch(1);
    public CheckoutTSReceiver(CheckoutRepository checkoutRepository) {

        checkoutService = new CheckoutService(checkoutRepository);
    }
    public void receiveMessage(String message) throws JsonProcessingException {
        System.out.println("Received <" + message + ">");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BillResultDto billResultDto = objectMapper.readValue(message, BillResultDto.class);
        checkoutService.updateBillCheckout(billResultDto);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
