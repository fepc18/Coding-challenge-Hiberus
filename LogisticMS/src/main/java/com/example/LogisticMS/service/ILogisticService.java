package com.example.LogisticMS.service;

import com.example.LogisticMS.domain.Logistic;
import com.example.LogisticMS.domain.CheckOut;

import java.util.List;

public interface ILogisticService {
    public Logistic createLogistic(CheckOut checkOut);
    public List<Logistic> getLogistics();

}
