# Stocks MCP Server Demo

This project is a simple MCP in Java 25 with Spring Boot 3.5.6, Spring AI MCP (1.1.0-M3) and WebFlux, connected to an H2 database via R2DBC.

You can use it independently or with this other solution:
https://github.com/dmarcosl/spring-ai-mcp-agent-demo

---

## 🐳 Run with Docker

### 1. Build the image

```bash
docker build -t stockmcp .
```

### 2. Run the container

```bash
docker run --rm -p 8085:8085 stockmcp
```

The server will be available at:

```
http://localhost:8085/mcp
```

To use it in VS Code, add this configuration to `settings.json`:

```json
{
  "servers": {
    "stock-mcp": {
      "type": "sse",
      "url": "http://localhost:8085/mcp"
    }
  }
}
```

---

## 🧩 Included tools

| Tool                            | Description                                                   |
|---------------------------------|---------------------------------------------------------------|
| `all_stocks()`                  | Returns quantity for each product    |
| `stock_by_product(name, color)` | Returns quantity for a given product |

---

## 🗄️ Database

The application uses H2 in-memory (R2DBC).  
It initializes automatically with the `schema.sql` and `data.sql` scripts.

---

## 🪪 License

MIT
