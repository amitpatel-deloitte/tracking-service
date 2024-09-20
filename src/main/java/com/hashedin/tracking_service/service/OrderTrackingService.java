package com.hashedin.tracking_service.service;

import com.hashedin.tracking_service.client.OrderClient;
import com.hashedin.tracking_service.exceptionHandler.NotFoundException;
import com.hashedin.tracking_service.exceptionHandler.OrderNotPlaced;
import com.hashedin.tracking_service.model.OrderDTO;
import com.hashedin.tracking_service.model.OrderStatus;
import com.hashedin.tracking_service.model.OrderTracking;
import com.hashedin.tracking_service.model.TrackingStatus;
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

    public OrderTracking startTracking(Long orderId){
        OrderDTO order = orderClient.getOrderById(orderId);

        if(order.getOrderStatus() == OrderStatus.PENDING){
            throw new OrderNotPlaced((" Order status is still pending. Tracking not available"));
        }

        OrderTracking tracking = new OrderTracking();
        tracking.setOrderId(order.getOrder_id());
        tracking.setCurrentStatus(order.getOrderStatus().name());
        tracking.setStatusUpdateTime(LocalDateTime.now());
        return trackingRepository.save(tracking);
    }

    public OrderTracking updateTracking(Long trackingId, TrackingStatus newStatus){
        OrderTracking tracking = trackingRepository.findTrackingById(trackingId)
                .orElseThrow(() -> new NotFoundException(" Tracking not found for the tracking id " + trackingId));
        tracking.setCurrentStatus(newStatus.name());
        tracking.setStatusUpdateTime(LocalDateTime.now());
        return trackingRepository.save(tracking);
    }

    public OrderTracking getTrackingByOrderId(Long trackingId){
        return trackingRepository.findTrackingById(trackingId)
                .orElseThrow(() -> new NotFoundException(" Tracking not found for the tracking id  " + trackingId));
    }


}
