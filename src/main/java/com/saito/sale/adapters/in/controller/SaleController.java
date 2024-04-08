package com.saito.sale.adapters.in.controller;

import com.saito.sale.adapters.in.controller.request.SaleRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest aSaleRequest){
        log.info("Creating a sale...");

    }
}
