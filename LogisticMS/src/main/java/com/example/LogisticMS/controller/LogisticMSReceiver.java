package com.example.LogisticMS.controller;

import com.example.LogisticMS.domain.Logistic;
import com.example.LogisticMS.domain.CheckOut;
import com.example.LogisticMS.infrastructure.LogisticRepository;
import com.example.LogisticMS.service.LogisticService;
import com.example.LogisticMS.service.ILogisticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
@Component
public class LogisticMSReceiver {
    @Autowired
    private ILogisticService logisticService;

    private CountDownLatch latch = new CountDownLatch(1);

    public LogisticMSReceiver(LogisticRepository logisticRepository) {
        this.logisticService = new LogisticService(logisticRepository);
    }

    public void receiveMessage(String message) throws JsonProcessingException {
        System.out.println("Bill Received <" + message + ">");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CheckOut checkOut = objectMapper.readValue(message, CheckOut.class);
        System.out.println("Message Deserialized <" + checkOut.getId() + ">");

        Logistic logisticResult = logisticService.createLogistic(checkOut);
        System.out.println("Bill Create <" + logisticResult.getId() + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
