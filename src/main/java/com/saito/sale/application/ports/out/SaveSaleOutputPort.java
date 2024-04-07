package com.saito.sale.application.ports.out;

import com.saito.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale aSale);
}
