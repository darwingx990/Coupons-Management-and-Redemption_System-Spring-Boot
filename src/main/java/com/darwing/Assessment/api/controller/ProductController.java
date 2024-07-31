package com.darwing.Assessment.api.controller;

import com.darwing.Assessment.domain.entities.Product;
import com.darwing.Assessment.infrastructure.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
        final ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products", description = "This endpoint Returns a paginated list of all products.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request sent Successfully. This Returns the paginated list of suppliers."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur when the information sent is incorrect."),
            @ApiResponse(responseCode = "404", description = "Not found. This may occur when the product was not found or does not exist.")
    })
    public ResponseEntity<Page<Product>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(productService.getAll(pageable));
    }

}
