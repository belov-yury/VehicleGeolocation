package com.example.vehiclegeolocation.controller;

import com.example.vehiclegeolocation.controller.validator.VehicleValidator;
import com.example.vehiclegeolocation.dto.VehicleDto;
import com.example.vehiclegeolocation.entity.VehicleEntity;
import com.example.vehiclegeolocation.mapper.VehicleMapper;
import com.example.vehiclegeolocation.service.VehicleService;
import com.example.vehiclegeolocation.specification.criteria.VehicleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller("/vehicle")
public class VehicleController {


    private VehicleService vehicleService;

    private VehicleMapper vehicleMapper;

    private VehicleValidator vehicleValidator;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper, VehicleValidator vehicleValidator) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
        this.vehicleValidator = vehicleValidator;
    }

    @GetMapping
    public ResponseEntity getAll(@Valid VehicleCriteria vehicleCriteria) {
        List<VehicleDto> vehicles = vehicleService.findAll(vehicleCriteria).stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity save(@Valid VehicleDto vehicleDto) {
        VehicleEntity saved = vehicleService.save(vehicleMapper.toEntity(vehicleDto));
        return new ResponseEntity<>(vehicleMapper.toDto(saved), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity update(@Valid VehicleDto vehicleDto) {
        if (vehicleDto.getId() == null) {
            return new ResponseEntity<>("Set id field", HttpStatus.BAD_REQUEST);
        }
        Optional<VehicleEntity> optional = vehicleService.findById(vehicleDto.getId());
        if (!optional.isPresent()) {
            return new ResponseEntity<>("Vehicle not found", HttpStatus.BAD_REQUEST);
        }
        VehicleEntity updated = vehicleService.save(vehicleMapper.toEntity(vehicleDto, optional.get()));
        return new ResponseEntity<>(vehicleMapper.toDto(updated), HttpStatus.OK);
    }

    @InitBinder("vehicleCriteria")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(vehicleValidator);
    }
}
