package com.example.CheckoutTS.service;

import com.example.CheckoutTS.config.CheckoutMessagingConfig;
import com.example.CheckoutTS.domain.BillResultDto;
import com.example.CheckoutTS.domain.CheckOut;
import com.example.CheckoutTS.infrastructure.CheckoutRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService implements ICheckoutService
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private CheckoutRepository repository;
    public CheckoutService(CheckoutRepository repository) {
        this.repository=repository;
    }

    @Override
    public CheckOut createCheckout(CheckOut checkOut) {
        checkOut.generateId();
        //Mensaje del  evento "CheckoutCreated"
        System.out.println("Sending message...");

        repository.save(checkOut);
        rabbitTemplate.convertAndSend(CheckoutMessagingConfig.topicExchangeName, "foo.bar.abc", checkOut.toString());
        System.out.println("Publish event inscriptionCreated");
        return checkOut;

    }

    @Override
    public void updateBillCheckout(BillResultDto billResultDto) {
        Optional<CheckOut> optional= repository.findById(billResultDto.getCheckOutId());
        if(optional.isPresent()){
            CheckOut checkOut= optional.get();
            checkOut.setBillResult(billResultDto.getId());
            repository.save(checkOut);
        }
    }

    @Override
    public List<CheckOut> getCheckOuts() {
        return repository.findAll();
    }



}
