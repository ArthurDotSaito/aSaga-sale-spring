package com.saito.sale.application.core.usecases;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleStatus;
import com.saito.sale.application.ports.in.FindSaleByIdInputPort;
import com.saito.sale.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase {

    private final FindSaleByIdInputPort findSaleByIdInputPort;

    private final SaveSaleOutputPort saveSaleOutputPort

    public FinalizeSaleUseCase(
            FindSaleByIdInputPort findSaleByIdInputPort,
            SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    public void finalize(Sale aSale){
        var saleResponse = findSaleByIdInputPort.find(aSale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }
}
