package com.saito.sale.application.core.usecases;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleEvent;
import com.saito.sale.application.core.domain.enums.SaleStatus;
import com.saito.sale.application.ports.in.CreateSaleInputPort;
import com.saito.sale.application.ports.out.SaveSaleOutputPort;
import com.saito.sale.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;

    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort,
                             SendCreatedSaleOutputPort sendCreatedSaleOutputPort
    )
    {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    @Override
    public void create(Sale aSale){
        aSale.setStatus(SaleStatus.PENDING);

        var saleResponse = saveSaleOutputPort.save(aSale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
