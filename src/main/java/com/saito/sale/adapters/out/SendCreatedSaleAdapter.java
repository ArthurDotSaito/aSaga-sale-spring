package com.saito.sale.adapters.out;

import com.saito.sale.adapters.out.message.SaleMessage;
import com.saito.sale.application.core.domain.Sale;
import com.saito.sale.application.core.domain.enums.SaleEvent;
import com.saito.sale.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTeamplate;

    @Override
    public void send(Sale aSale, SaleEvent aEvent) {
        var saleMessage = new SaleMessage(aSale, aEvent);

        kafkaTeamplate.send("tp-saga-sale", saleMessage);
    }
}
