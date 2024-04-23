package com.saito.sale.application.core.usecases;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleStatus;
import com.saito.sale.application.ports.in.CancelSaleInputPort;
import com.saito.sale.application.ports.in.FindSaleByIdInputPort;
import com.saito.sale.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(
            FindSaleByIdInputPort findSaleByIdInputPort,
            SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale aSale){
        var saleResponse = findSaleByIdInputPort.find(aSale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }
}
