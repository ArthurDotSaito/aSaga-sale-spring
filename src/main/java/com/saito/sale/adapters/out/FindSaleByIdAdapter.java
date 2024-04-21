package com.saito.sale.adapters.out;

import com.saito.sale.adapters.out.repository.SaleRepository;
import com.saito.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer anId) {
        var saleEntity = saleRepository.findById(anId);
        return saleEntity.map(saleEntityMapper::toSale);
    }
}
