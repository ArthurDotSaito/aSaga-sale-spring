package com.saito.sale.adapters.in.controller.mapper;

import com.saito.sale.adapters.in.controller.request.SaleRequest;
import com.saito.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest aSaleRequest);
}
