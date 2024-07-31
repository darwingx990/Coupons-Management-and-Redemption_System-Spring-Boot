package com.darwing.Assessment.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(nullable = false)
  @Lob
  private String description;

  @Column(nullable = false)
  private double price;
}
