package com.example.CheckoutTS.service;

import com.example.CheckoutTS.domain.BillResultDto;
import com.example.CheckoutTS.domain.CheckOut;

import java.util.List;

public interface ICheckoutService {
    public CheckOut createCheckout(CheckOut checkOut);
    public void updateBillCheckout(BillResultDto billResultDto);
    public List<CheckOut> getCheckOuts();

}
