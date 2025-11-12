package com.dmarcosl.stockmcp.tools;

import com.dmarcosl.stockmcp.domain.StockService;
import lombok.RequiredArgsConstructor;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockTools {

  private final StockService stockService;

  @McpTool(
      name = "all_stocks",
      description = "Returns quantity for each product")
  public Mono<List<StockService.StockSummary>> allStocks() {
    return stockService.getAllStockSummaries().collectList();
  }

  @McpTool(
      name = "stock_by_product",
      description = "Returns quantity for a given product")
  public Mono<StockService.StockSummary> stockByProduct(
      @ToolParam(description = "Name of the product (i.e. 'skirt')") String name,
      @ToolParam(description = "Color of the product (i.e. 'pink')") String color) {
    if (!StringUtils.hasText(name) || !StringUtils.hasText(color)) {
      throw new IllegalArgumentException("Missing parameters: name and color");
    }
    return stockService.getStockSummaryByProduct(name, color);
  }
}
