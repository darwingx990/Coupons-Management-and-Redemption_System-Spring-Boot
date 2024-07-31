package com.darwing.Assessment.infrastructure.services;

import java.util.Optional;
import java.util.UUID;

import com.darwing.Assessment.domain.entities.Product;
import com.darwing.Assessment.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

  @Autowired
  private final ProductRepository productRepository;

  public Page<Product> getAll(Pageable pageable) {
      return productRepository.findAll(pageable);
  }

}
