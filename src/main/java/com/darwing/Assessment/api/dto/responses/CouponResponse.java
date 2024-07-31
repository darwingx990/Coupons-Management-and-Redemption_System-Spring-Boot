package com.darwing.Assessment.api.dto.responses;

import java.time.LocalDateTime;

import com.darwing.Assessment.util.enums.CouponStatus;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponse {
    private Long id;
    private LocalDateTime expirationDate;
    private float discount;
    private String code;
    private CouponStatus status;
}
