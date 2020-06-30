package com.example.LogisticMS.service;

import com.example.LogisticMS.domain.CheckOut;
import com.example.LogisticMS.infrastructure.LogisticRepository;

import com.example.LogisticMS.domain.Logistic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.example.LogisticMS.config.LogisticMessagingConfig.topicExchangeName;

@Service
public class LogisticService implements ILogisticService
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private LogisticRepository repository;
    public LogisticService(LogisticRepository repository) {
        this.repository=repository;
    }

    @Override
    public Logistic createLogistic(CheckOut checkOut) {

        Logistic logistic = new Logistic(checkOut.getId(), checkOut.getClientId(),checkOut.getDate().toString(),checkOut.getProducts());
        repository.save(logistic);
        return logistic;

    }

    @Override
    public List<Logistic> getLogistics() {
        return repository.findAll();
    }

}
