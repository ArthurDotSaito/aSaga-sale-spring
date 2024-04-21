package com.saito.sale.config.useCase;

import com.saito.sale.adapters.out.FindSaleByIdAdapter;
import com.saito.sale.application.core.usecases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(FindSaleByIdAdapter findSaleByIdAdapter){
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }

}
