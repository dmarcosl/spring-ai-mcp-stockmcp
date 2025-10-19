package com.dmarcosl.stockmcp.tools;

import com.dmarcosl.stockmcp.domain.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockTools {

  private final StockService stockService;

  @Tool(
      name = "all_stocks",
      description = "Returns quantity for each product")
  public List<StockService.StockSummary> allStocks() {
    return stockService.getAllStockSummaries().collectList().block();
  }

  @Tool(
      name = "stock_by_product",
      description = "Returns quantity for a given product")
  public StockService.StockSummary stockByProduct(
      @ToolParam(description = "Name of the product (i.e. 'skirt')") String name,
      @ToolParam(description = "Color of the product (i.e. 'pink')") String color) {
    if (!StringUtils.hasText(name) || !StringUtils.hasText(color)) {
      throw new IllegalArgumentException("Missing parameters: name and color");
    }
    return stockService.getStockSummaryByProduct(name, color).block();
  }
}
