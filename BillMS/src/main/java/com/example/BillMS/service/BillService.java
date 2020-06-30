package com.example.BillMS.service;

import com.example.BillMS.domain.CheckOut;
import com.example.BillMS.infrastructure.BillRepository;

import com.example.BillMS.config.BillMessagingConfig;
import com.example.BillMS.domain.Bill;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.example.BillMS.config.BillMessagingConfig.topicExchangeName;

@Service
public class BillService implements IBillService
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private BillRepository repository;
    public BillService(BillRepository repository) {
        this.repository=repository;
    }

    @Override
    public Bill createBill(CheckOut checkOut) {

        Bill bill= new Bill(checkOut.getId(), checkOut.getClientId(),checkOut.getDate().toString(),checkOut.getProducts());
        System.out.println("Sending message createBill...");
        repository.save(bill);
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", bill.toString());
        System.out.println("Publish event BillCreatedSuccess");
        return bill;

    }


    @Override
    public List<Bill> getBills() {
        return repository.findAll();
    }

}
