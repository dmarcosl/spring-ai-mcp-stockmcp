package com.dmarcosl.stockmcp.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
  @Id private Long id;

  @Column("product_id")
  private Long productId;

  private Integer quantity;

  private String location;
}
