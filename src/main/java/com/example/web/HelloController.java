package com.example.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple GET endpoint to trigger the full MVC path:
 * FilterChain -> DispatcherServlet -> HandlerMapping/Adapter -> Controller -> HttpMessageConverter
 */
@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public ResponseEntity<Map<String, Object>> hello() {
        // Create a small DTO map to exercise JSON serialization (HttpMessageConverter)
        Map<String, Object> body = new HashMap<>();
        body.put("message", "hello");
        body.put("ts", Instant.now().toString());
        return ResponseEntity.ok(body);
    }
}