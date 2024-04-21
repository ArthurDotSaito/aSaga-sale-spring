package com.saito.sale.application.core.usecases;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.ports.in.FindSaleByIdInputPort;
import com.saito.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Integer anId){
        return findSaleByIdOutputPort.find(anId)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    };
}
