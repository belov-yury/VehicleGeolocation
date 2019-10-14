package com.example.vehiclegeolocation.controller.validator;

import com.example.vehiclegeolocation.specification.criteria.VehicleCriteria;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class VehicleValidator implements Validator {


    public boolean supports(Class<?>  clazz) {
        return VehicleCriteria.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {

        VehicleCriteria criteria = (VehicleCriteria) obj;

        if (criteria.getX1() == null || criteria.getX2() == null || criteria.getY1() == null || criteria.getY2() == null) {
            e.reject("Invalid rectangle");
        } else if (criteria.getX1() > criteria.getX2() || criteria.getY1() > criteria.getY2()) {
            e.reject("x2 and  y2  must be greater than x1 and y1. Support for other types of rectangles will be added in the next version");
        }
    }
}
