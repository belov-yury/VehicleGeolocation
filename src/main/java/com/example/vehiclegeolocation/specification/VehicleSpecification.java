package com.example.vehiclegeolocation.specification;

import com.example.vehiclegeolocation.entity.VehicleEntity;
import com.example.vehiclegeolocation.specification.criteria.VehicleCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VehicleSpecification implements Specification<VehicleEntity> {

    private VehicleCriteria criteria;

    public VehicleSpecification(VehicleCriteria criteria) {
        super();
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<VehicleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.between(root.get("xCoordinate"), criteria.getX1(), criteria.getX2()));
        predicates.add(criteriaBuilder.between(root.get("yCoordinate"), criteria.getY1(), criteria.getY2()));
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
