package com.example.BillMS.controller;

import com.example.BillMS.domain.Bill;
import com.example.BillMS.infrastructure.BillRepository;
import com.example.BillMS.service.BillService;
import com.example.BillMS.service.IBillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Bill/v1")
@Component
public class BillMSController {

    @Autowired
    private IBillService BillService;
    @Autowired
    private ModelMapper modelMapper;

    public BillMSController(BillRepository BillRepository) {
        BillService = new BillService(BillRepository);
    }

    @RequestMapping("/bills")
    public List<Bill> getBills() {
        return BillService.getBills();
    }


}


