package com.darwing.Assessment.api.dto.requests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {

   @NotNull(message = "expiration date req is required")
    @JsonProperty("expiration_date")
    private LocalDate expirationDate;

    @NotNull(message = "Percentage of the discount is required")
    private int discount;

    @NotBlank(message = "Code is required")
    @Size(min = 1, max = 50, message = "The code must be between 1 and 50 characters long.")
    private String code;
}
