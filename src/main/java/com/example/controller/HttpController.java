package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HttpController {

    @GetMapping("/api/http")
    public ResponseEntity<Map<String, Object>> http() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "HTTP request received");
        body.put("timestamp", Instant.now().toString());
        return ResponseEntity.ok(body);
    }
}