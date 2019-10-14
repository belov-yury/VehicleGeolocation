package com.example.vehiclegeolocation.service.imp;

import com.example.vehiclegeolocation.entity.VehicleEntity;
import com.example.vehiclegeolocation.repository.VehicleRepository;
import com.example.vehiclegeolocation.service.VehicleService;
import com.example.vehiclegeolocation.specification.VehicleSpecification;
import com.example.vehiclegeolocation.specification.criteria.VehicleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleEntity save(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

    @Override
    public List<VehicleEntity> findAll(VehicleCriteria vehicleCriteria) {
        return vehicleRepository.findAll(new VehicleSpecification(vehicleCriteria));
    }

    @Override
    public Optional<VehicleEntity> findById(Long id) {
        return vehicleRepository.findById(id);
    }
}
