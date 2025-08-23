package com.example.filter;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest req,
                                    @NonNull HttpServletResponse res,
                                    @NonNull FilterChain chain) throws ServletException, IOException {
        String rid = java.util.UUID.randomUUID().toString();
        long start = System.nanoTime();

        req.setAttribute("requestId", rid);
        res.addHeader("X-Request-Id", rid);

        if (logger.isInfoEnabled()) {
            logger.info("[Filter:BEGIN] rid=" + rid +
                    " method=" + req.getMethod() + " uri=" + req.getRequestURI());
        }

        try {
            chain.doFilter(req, res);
        } finally {
            long tookMs = (System.nanoTime() - start) / 1_000_000;
            if (logger.isInfoEnabled()) {
                logger.info("[Filter:END]   rid=" + rid +
                        " status=" + res.getStatus() + " tookMs=" + tookMs);
            }
        }
    }
}