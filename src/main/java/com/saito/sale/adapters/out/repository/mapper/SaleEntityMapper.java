package com.saito.sale.adapters.out.repository.mapper;


import com.saito.sale.adapters.out.repository.entity.SaleEntity;
import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale aSale);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus){
        return saleStatus.getStatusId();
    }
}
