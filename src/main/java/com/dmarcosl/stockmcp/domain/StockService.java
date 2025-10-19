package com.dmarcosl.stockmcp.domain;

import com.dmarcosl.stockmcp.db.Product;
import com.dmarcosl.stockmcp.db.ProductRepository;
import com.dmarcosl.stockmcp.db.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {

  private final ProductRepository productRepository;
  private final StockRepository stockRepository;

  public record StockSummary(String name, String color, int quantity) {}

  public Flux<StockSummary> getAllStockSummaries() {
    log.info("[getAllStockSummaries] Start");
    return productRepository
        .findAll()
        .flatMap(
            (Product p) ->
                stockRepository
                    .getStockByProduct(p.getId())
                    .map(cnt -> new StockSummary(p.getName(), p.getColor(), cnt)))
        .doOnError(e -> log.error("[getAllStockSummaries] error", e))
        .doOnComplete(() -> log.info("[getAllStockSummaries] end"));
  }

  public Mono<StockSummary> getStockSummaryByProduct(String name, String color) {
    log.info("[getStockSummaryByProduct] Start for {} ({})", name, color);
    return productRepository
        .findByNameAndColor(name, color)
        .switchIfEmpty(
            Mono.error(
                new IllegalArgumentException("Product no found: %s (%s)".formatted(name, color))))
        .flatMap(
            (Product p) ->
                stockRepository
                    .getStockByProduct(p.getId())
                    .map(cnt -> new StockSummary(p.getName(), p.getColor(), cnt)))
        .doOnError(e -> log.error("[getStockSummaryByProduct] error", e))
        .doOnSuccess(stockSummary -> log.info("[getStockSummaryByProduct] end"));
  }
}
