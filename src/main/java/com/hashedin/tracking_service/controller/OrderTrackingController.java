package com.hashedin.tracking_service.controller;

import com.hashedin.tracking_service.model.OrderTracking;
import com.hashedin.tracking_service.model.TrackingStatus;
import com.hashedin.tracking_service.service.OrderTrackingService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
@OpenAPIDefinition(
        info = @Info(title = " Order Tracking System")
)
@Tag(name = "Order Tracking System", description = "Operations pertaining to order tracking in Order Tracking System")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService trackingService;

    @PostMapping("/start-tracking/{orderId}")
    @Operation(summary = "Start tracking ", description = " Once order is place .. start tracking")
    public OrderTracking startTracking(@PathVariable Long orderId){
        return trackingService.startTracking(orderId);
    }

    @PutMapping("/update-tracking-status/{trackingId}")
    @Operation(summary = " Update Tracking", description = " Update the tracking status once tracking starts")
    public OrderTracking updateOrderStatus(@PathVariable Long trackingId, @RequestParam TrackingStatus trackingStatus){
        return trackingService.updateTracking(trackingId, trackingStatus);
    }

    @GetMapping("/tracking-status/{trackingId}")
    @Operation(summary = " Get tracking status ", description = " Get the tracking status once tracking starts")
    public OrderTracking getTracking(@PathVariable Long trackingId){
        return trackingService.getTrackingByOrderId(trackingId);
    }
}
