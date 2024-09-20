package com.hashedin.tracking_service.controller;

import com.hashedin.tracking_service.model.OrderTracking;
import com.hashedin.tracking_service.service.OrderTrackingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
@Tag(name = "Order Tracking System", description = "Operations pertaining to order tracking in Order Tracking System")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService trackingService;

    @PostMapping("/start-tracking/{orderId}")
    public OrderTracking startTracking(@PathVariable("orderId") int orderId){
        return trackingService.startTracking(orderId);
    }

    @PutMapping("/update-tracking-status/{orderId}")
    public OrderTracking updateOrderStatus(@PathVariable("orderId") int orderId, @RequestParam String newStatus){
        return trackingService.updateTracking(orderId, newStatus);
    }

    @GetMapping("/tracking-status/{orderId}")
    public OrderTracking getTracking(@PathVariable("orderId") int orderId){
        return trackingService.getTrackingByOrderId(orderId);
    }
}
