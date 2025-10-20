package com.parth.Garage.Dto;

import lombok.Data;


import java.time.LocalDateTime;


@Data
public class AppointmentDto {
    private Long vehicleId;
    private Long mechanicId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String notes;
}