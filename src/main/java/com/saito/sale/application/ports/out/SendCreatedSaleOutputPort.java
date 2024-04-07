package com.saito.sale.application.ports.out;

import com.saito.sale.application.core.domain.Sale;

public interface SendCreatedSaleOutputPort {

    void send(Sale aSale, SaleEvent aEvent);

}
