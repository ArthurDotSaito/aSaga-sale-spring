package com.saito.sale.config.useCase;

import com.saito.sale.adapters.out.SaveSaleAdapter;
import com.saito.sale.application.core.usecases.FinalizeSaleUseCase;
import com.saito.sale.application.core.usecases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ){
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
