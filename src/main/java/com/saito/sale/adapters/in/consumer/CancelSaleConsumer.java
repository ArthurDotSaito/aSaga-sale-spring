package com.saito.sale.adapters.in.consumer;

import com.saito.sale.adapters.out.message.SaleMessage;
import com.saito.sale.application.core.domain.enums.SaleEvent;
import com.saito.sale.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelSaleConsumer {

    @Autowired
    private CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getEvent())){
            log.info("Canceling a sale...");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Sale cancelled succesfully...");
        }
    }
}
