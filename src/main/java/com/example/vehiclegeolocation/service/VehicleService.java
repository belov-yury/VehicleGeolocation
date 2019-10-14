package com.example.vehiclegeolocation.service;

import com.example.vehiclegeolocation.entity.VehicleEntity;
import com.example.vehiclegeolocation.specification.criteria.VehicleCriteria;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    VehicleEntity save(VehicleEntity vehicleEntity);

    List<VehicleEntity> findAll(VehicleCriteria vehicleCriteria);

    Optional<VehicleEntity> findById(Long id);
}
