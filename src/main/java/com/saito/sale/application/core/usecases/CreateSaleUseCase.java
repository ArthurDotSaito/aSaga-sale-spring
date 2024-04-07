package com.saito.sale.application.core.usecases;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleStatus;
import com.saito.sale.application.ports.out.SaveSaleOutputPort;

public class CreateSaleUseCase {

    private final SaveSaleOutputPort saveSaleOutputPort;

    public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort){
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    public void create(Sale aSale){
        aSale.setStatus(SaleStatus.PENDING);

        var saleResponse = saveSaleOutputPort.save(aSale);
    }
}
