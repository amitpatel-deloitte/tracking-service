package com.hashedin.tracking_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tracking")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderId;
    private String currentStatus;
    private LocalDateTime statusUpdateTime;
}
