package com.hashedin.tracking_service.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Hidden
public class OrderDTO {
    private int id;
    private int restaurant_id;
    private int user_id;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
}
