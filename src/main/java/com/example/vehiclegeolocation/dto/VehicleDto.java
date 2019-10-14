package com.example.vehiclegeolocation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDto {

    private Long id;
    private String name;
    @NotNull
    private Double xCoordinate;
    @NotNull
    private Double yCoordinate;
}
