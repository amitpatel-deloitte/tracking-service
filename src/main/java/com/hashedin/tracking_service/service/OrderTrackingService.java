package com.hashedin.tracking_service.service;

import com.hashedin.tracking_service.client.OrderClient;
import com.hashedin.tracking_service.model.OrderDTO;
import com.hashedin.tracking_service.model.OrderTracking;
import com.hashedin.tracking_service.repository.OrderTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderTrackingService {

    @Autowired
    private OrderTrackingRepository trackingRepository;

    @Autowired
    private OrderClient orderClient;

    public OrderTracking startTracking(int orderId){
        OrderDTO order = orderClient.getOrderById(orderId);

        OrderTracking tracking = new OrderTracking();
        tracking.setOrderId(order.getId());
        tracking.setCurrentStatus("ORDER Placed");
        tracking.setStatusUpdateTime(LocalDateTime.now());
        return trackingRepository.save(tracking);
    }

    public OrderTracking updateTracking(int orderId, String newStatus){
        OrderTracking tracking = trackingRepository.findOrderById(orderId)
                .orElseThrow(() -> new RuntimeException(" Tracking not found for the order " + orderId));
        tracking.setCurrentStatus(newStatus);
        tracking.setStatusUpdateTime(LocalDateTime.now());
        return trackingRepository.save(tracking);
    }

    public OrderTracking getTrackingByOrderId(int orderId){
        return trackingRepository.findOrderById(orderId)
                .orElseThrow(() -> new RuntimeException(" Tracking not found for the order " + orderId));
    }


}
