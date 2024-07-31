package com.darwing.Assessment.domain.repositories;

import java.util.UUID;

import com.darwing.Assessment.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
