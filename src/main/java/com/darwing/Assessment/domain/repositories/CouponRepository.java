package com.darwing.Assessment.domain.repositories;

import java.util.UUID;

import com.darwing.Assessment.domain.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long>{

}