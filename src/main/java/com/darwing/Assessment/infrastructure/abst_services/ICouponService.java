package com.darwing.Assessment.infrastructure.abst_services;

import com.darwing.Assessment.api.dto.requests.CouponRequest;
import com.darwing.Assessment.api.dto.requests.UpdateCouponRequest;
import com.darwing.Assessment.api.dto.responses.CouponResponse;
import com.darwing.Assessment.infrastructure.abst_services.generics.*;


public interface ICouponService extends CreateService<CouponRequest, CouponResponse>, ReadAllService<CouponResponse>,
        UpdateService<UpdateCouponRequest, CouponResponse, Long>, DeleteService<Long>, ReadService<CouponResponse, Long> {

}
