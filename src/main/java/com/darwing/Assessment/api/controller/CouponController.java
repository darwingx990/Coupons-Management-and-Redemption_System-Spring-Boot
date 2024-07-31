package com.darwing.Assessment.api.controller;

import com.darwing.Assessment.api.dto.requests.CouponRequest;
import com.darwing.Assessment.api.dto.requests.UpdateCouponRequest;
import com.darwing.Assessment.api.dto.responses.CouponResponse;
import com.darwing.Assessment.infrastructure.abst_services.ICouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/coupon")
@AllArgsConstructor
public class CouponController {

    private final ICouponService couponsService;

    @PostMapping
    @Operation(summary = "Create coupon", description = "This endpoint returned when a coupon is created.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request sent Successfully. This Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur when the information sent is incorrect."),
            @ApiResponse(responseCode = "404", description = "Not found. This may occur when the coupon was not found or does not exist.")
    })
    public ResponseEntity<CouponResponse> create(
            @Validated @RequestBody CouponRequest request) {
        return ResponseEntity.ok(this.couponsService.create(request));
    }

    @GetMapping
    @Operation(summary = "Get all coupons", description = "This endpoint Returns a paginated list of all coupons.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request sent Successfully. This Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur when the information sent is incorrect."),
            @ApiResponse(responseCode = "404", description = "Not found. This may occur when the coupon was not found or does not exist.")
    })
    public ResponseEntity<Page<CouponResponse>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(couponsService.getAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a coupon by Id", description = "This endpoint Returns a coupon info by getting its Id as a parameter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request sent Successfully. This Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur when the information sent is incorrect."),
            @ApiResponse(responseCode = "404", description = "Not found. This may occur when the coupon was not found or does not exist.")
    })
    public ResponseEntity<Optional<CouponResponse>> getCouponById(@PathVariable Long id) {
        return ResponseEntity.ok(couponsService.getById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete coupon by Id", description = "This endpoint remove a coupon by getting uts Id. It does not any return info or message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Request sent Successfully. This means the coupon was deleted."),
            @ApiResponse(responseCode = "404", description = "Not found. This may occur when the coupon was not found or does not exist.")
    })
    public ResponseEntity<Void> deletecoupons(@PathVariable Long id) {
        couponsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update coupon by Id", description = "This endpoint returns a cuppon Updated by giving the id as a parameter.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request sent Successfully. This Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur when the information sent is incorrect.")})
    public ResponseEntity<CouponResponse> updateCoupon(@PathVariable Long id, @Validated @RequestBody UpdateCouponRequest couponReq) {
        return ResponseEntity.ok(couponsService.update(id, couponReq));
    }


}
