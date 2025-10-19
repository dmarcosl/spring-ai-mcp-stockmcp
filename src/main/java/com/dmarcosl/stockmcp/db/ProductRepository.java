package com.dmarcosl.stockmcp.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
  Mono<Product> findByNameAndColor(String name, String color);
}
