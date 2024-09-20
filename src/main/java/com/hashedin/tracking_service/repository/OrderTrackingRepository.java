package com.hashedin.tracking_service.repository;

import com.hashedin.tracking_service.model.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Long> {

    Optional<OrderTracking> findTrackingById( Long orderId);
}

