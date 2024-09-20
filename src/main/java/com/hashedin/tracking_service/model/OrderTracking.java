package com.hashedin.tracking_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = " Order Id ")
    private int orderId;
    @Schema(description = " The current tracking status ")
    private String currentStatus;
    @Schema(description = " last status update time")
    private LocalDateTime statusUpdateTime;
}
