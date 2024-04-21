package com.saito.sale.application.ports.in;

import com.saito.sale.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale aSale);
}
