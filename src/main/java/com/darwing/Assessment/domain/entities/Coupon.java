package com.darwing.Assessment.domain.entities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.darwing.Assessment.util.enums.CouponStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private int discount;

    @Column(nullable = false, length = 50)
    private String code;


    @Enumerated(EnumType.STRING)
    private CouponStatus status;

}