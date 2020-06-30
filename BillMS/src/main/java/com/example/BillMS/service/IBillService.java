package com.example.BillMS.service;

import com.example.BillMS.domain.Bill;
import com.example.BillMS.domain.CheckOut;

import java.util.List;

public interface IBillService {
    public Bill createBill(CheckOut checkOut);
    public List<Bill> getBills();

}
