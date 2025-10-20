package com.parth.Garage.entity;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String make; // e.g. Toyota
    private String model;
    private String registrationNumber;
    private Integer year;


    @ManyToOne
    private Customer owner;
}