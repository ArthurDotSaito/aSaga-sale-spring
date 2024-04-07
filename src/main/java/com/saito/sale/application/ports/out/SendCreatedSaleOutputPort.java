package com.saito.sale.application.ports.out;

import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale aSale, SaleEvent aEvent);
}
