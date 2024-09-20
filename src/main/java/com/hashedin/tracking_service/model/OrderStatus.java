package com.hashedin.tracking_service.model;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public enum OrderStatus {
    PLACED ,
    ACCEPTED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED
}
