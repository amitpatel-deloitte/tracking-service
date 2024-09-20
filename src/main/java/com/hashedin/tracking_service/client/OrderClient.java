package com.hashedin.tracking_service.client;

import com.hashedin.tracking_service.model.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8083")
public interface OrderClient {

    @GetMapping("/orders/{orderId")
    OrderDTO getOrderById(@PathVariable("orderId") int orderId);
}
