package com.example.CheckoutTS.controller;

import com.example.CheckoutTS.domain.CheckOut;
import com.example.CheckoutTS.domain.OrdenDTO;
import com.example.CheckoutTS.infrastructure.CheckoutRepository;
import com.example.CheckoutTS.service.CheckoutService;
import com.example.CheckoutTS.service.ICheckoutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/checkout/v1")
@Component
public class CheckoutTSController {

    @Autowired
    private ICheckoutService checkoutService;
    @Autowired
    private ModelMapper modelMapper;

    public CheckoutTSController(CheckoutRepository checkoutRepository) {

        checkoutService = new CheckoutService(checkoutRepository);
    }

    //@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")

    public ResponseEntity<String> createCheckout(@RequestBody OrdenDTO orderDto) {
        if(!orderDto.modelIsValid()) {
            String message="The order has no products";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        //   CheckOut checkOut = modelMapper.map( orderDto, CheckOut.class);

        CheckOut checkOut = new CheckOut(orderDto.getClientId(),orderDto.getDate(),orderDto.getDirection(),orderDto.getProducts());

        CheckOut checkoutResult = checkoutService.createCheckout(checkOut);
        return ResponseEntity.ok(checkOut.getId());
    }


}


