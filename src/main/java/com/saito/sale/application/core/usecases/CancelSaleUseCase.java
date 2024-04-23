package com.saito.sale.application.core.usecases;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleStatus;
import com.saito.sale.application.ports.in.CancelSaleInputPort;
import com.saito.sale.application.ports.out.FindSaleByIdOutputPort;
import com.saito.sale.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(
            FindSaleByIdOutputPort findSaleByIdOutputPort,
            SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale aSale){
        var saleResponse = findSaleByIdOutputPort.find(aSale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }
}
