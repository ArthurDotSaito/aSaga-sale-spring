package com.saito.sale.config.useCase;

import com.saito.sale.adapters.out.SaveSaleAdapter;
import com.saito.sale.application.core.usecases.CancelSaleUseCase;
import com.saito.sale.application.core.usecases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
        FindSaleByIdUseCase findSaleByIdUseCase,
        SaveSaleAdapter saveSaleAdapter
    ){
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
