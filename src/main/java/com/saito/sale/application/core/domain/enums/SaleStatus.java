package com.saito.sale.application.core.domain.enums;

import java.util.Arrays;

public enum SaleStatus {

    PENDING(1),
    FINALIZED(2),
    CANCELED(3);

    private final Integer statusId;

    SaleStatus(Integer statusId){
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public static SaleStatus toEnum(Integer anId){
        if(anId == null) return null;
        return Arrays.stream(SaleStatus.values()).filter(status -> anId.equals(status.getStatusId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("status Id is invalid" + anId));
    }
}
