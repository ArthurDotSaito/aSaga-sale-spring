package com.saito.sale.adapters.out;

import com.saito.sale.adapters.out.repository.SaleRepository;
import com.saito.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale aSale) {
        var saleEntity = saleEntityMapper.toSaleEntity(aSale);
        var saleEntityResponse = saleRepository.save(saleEntity);

        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
