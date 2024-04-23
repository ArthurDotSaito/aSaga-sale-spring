package com.saito.sale.config.useCase;

import com.saito.sale.adapters.out.SaveSaleAdapter;
import com.saito.sale.adapters.out.SendCreatedSaleAdapter;
import com.saito.sale.application.core.usecases.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter
    ){
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }

}
