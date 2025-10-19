package com.dmarcosl.stockmcp.db;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {
  @Query("SELECT SUM(quantity) FROM stock WHERE product_id = :productId")
  Mono<Integer> getStockByProduct(Long productId);
}
