package com.example.LogisticMS.controller;

import com.example.LogisticMS.domain.Logistic;
import com.example.LogisticMS.infrastructure.LogisticRepository;
import com.example.LogisticMS.service.LogisticService;
import com.example.LogisticMS.service.ILogisticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Bill/v1")
@Component
public class LogisticMSController {

    @Autowired
    private ILogisticService BillService;
    @Autowired
    private ModelMapper modelMapper;

    public LogisticMSController(LogisticRepository LogisticRepository) {
        BillService = new LogisticService(LogisticRepository);
    }

    @RequestMapping("/bills")
    public List<Logistic> getCourses() {
        return BillService.getLogistics();
    }


}


