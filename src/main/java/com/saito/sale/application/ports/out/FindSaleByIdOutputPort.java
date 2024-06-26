package com.saito.sale.application.ports.out;

import com.saito.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {
    Optional<Sale> find(final Integer anId);
}
