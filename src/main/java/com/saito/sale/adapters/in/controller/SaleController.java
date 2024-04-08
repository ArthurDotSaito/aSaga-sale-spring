package com.saito.sale.adapters.in.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(){

    }
}
