package com.example.vehiclegeolocation.mapper;

import com.example.vehiclegeolocation.dto.VehicleDto;
import com.example.vehiclegeolocation.entity.VehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDto toDto(VehicleEntity entity) {
        VehicleDto dto = new VehicleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setXCoordinate(entity.getXCoordinate());
        dto.setYCoordinate(entity.getYCoordinate());
        return dto;
    }

    public VehicleEntity toEntity(VehicleDto dto) {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setXCoordinate(dto.getXCoordinate());
        entity.setYCoordinate(dto.getYCoordinate());
        return entity;
    }

    public VehicleEntity toEntity(VehicleDto dto, VehicleEntity entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setXCoordinate(dto.getXCoordinate());
        entity.setYCoordinate(dto.getYCoordinate());
        return entity;
    }


}
