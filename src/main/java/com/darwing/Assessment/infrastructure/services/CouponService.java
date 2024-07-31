package com.darwing.Assessment.infrastructure.services;

import com.darwing.Assessment.api.controller.BadRequestController;
import com.darwing.Assessment.api.dto.requests.CouponRequest;
import com.darwing.Assessment.api.dto.requests.UpdateCouponRequest;
import com.darwing.Assessment.api.dto.responses.CouponResponse;
import com.darwing.Assessment.domain.entities.Coupon;
import com.darwing.Assessment.domain.repositories.CouponRepository;
import com.darwing.Assessment.infrastructure.abst_services.ICouponService;
import com.darwing.Assessment.infrastructure.mappers.CouponMapper;
import com.darwing.Assessment.util.enums.CouponStatus;
import com.darwing.Assessment.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CouponService implements ICouponService {

    @Autowired
    private final CouponMapper couponMapper;

    @Autowired
    private final CouponRepository couponRepository;

    @Override
    public CouponResponse create(CouponRequest request) {
        Coupon coupon = couponMapper.couponRequestToCouponEntity(request);
        coupon.setStatus(CouponStatus.ACTIVE);
        couponRepository.save(coupon);

        return couponMapper.couponEntityToCouponResponse(coupon);
    }

    @Override
    public Page<CouponResponse> getAll(Pageable pageable) {
        return couponRepository.findAll(pageable).map(couponMapper::couponEntityToCouponResponse);
    }

    @Override
    public CouponResponse update(Long id, UpdateCouponRequest request) {
        Coupon coupon = this.find(id);
        couponMapper.updateFromCouponRequest(request, coupon);
        if (coupon.getStatus().equals(CouponStatus.INACTIVE)) {
            throw new RuntimeException("Unable to update. This is an inactive coupon");
        } else {
            return couponMapper.couponEntityToCouponResponse(this.couponRepository.save(coupon));
        }
    }

    @Override
    public void delete(Long id) {
        Coupon coupon = this.find(id);
        couponRepository.delete(coupon);
    }

    @Override
    public Optional<CouponResponse> getById(Long id) {
        Optional<Coupon> coupon = Optional.ofNullable(this.find(id));
        if (coupon.isEmpty())
            throw new IdNotFoundException("Coupon", id);
        return coupon.map(couponMapper::couponEntityToCouponResponse);
    }

    public Coupon find(Long id) {
        return couponRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Coupon", id));
    }

}

