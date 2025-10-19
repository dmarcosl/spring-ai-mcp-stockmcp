package com.dmarcosl.stockmcp.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id private Long id;
  private String name;
  private String color;
  private BigDecimal price;
}
