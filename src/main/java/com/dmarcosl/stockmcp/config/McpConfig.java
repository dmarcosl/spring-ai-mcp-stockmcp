package com.dmarcosl.stockmcp.config;

import com.dmarcosl.stockmcp.tools.StockTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

  @Bean
  public ToolCallbackProvider stockToolCallbacks(StockTools stockTools) {
    return MethodToolCallbackProvider.builder().toolObjects(stockTools).build();
  }
}
