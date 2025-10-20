package com.parth.Garage.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Vehicle vehicle;


    @ManyToOne
    private Mechanic mechanic;


    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED
    private String notes;
}