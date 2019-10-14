package com.example.vehiclegeolocation.repository;

import com.example.vehiclegeolocation.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository  extends JpaRepository<VehicleEntity, Long>, JpaSpecificationExecutor<VehicleEntity> {
}
