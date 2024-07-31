package com.darwing.Assessment.infrastructure.mappers;

import com.darwing.Assessment.api.dto.requests.CouponRequest;
import com.darwing.Assessment.api.dto.requests.UpdateCouponRequest;
import com.darwing.Assessment.api.dto.responses.CouponResponse;
import com.darwing.Assessment.domain.entities.Coupon;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface CouponMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", ignore = true)
    })
    Coupon couponRequestToCouponEntity(CouponRequest couponRequest);

    @InheritInverseConfiguration
    CouponRequest couponEntityToCouponRequest(Coupon coupon);

    CouponResponse couponEntityToCouponResponse(Coupon coupon);

    @Mapping(target = "status", source = "couponStatus")
    void updateFromCouponRequest(UpdateCouponRequest couponRequest, @MappingTarget Coupon coupon);

}
