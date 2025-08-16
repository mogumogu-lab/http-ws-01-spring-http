package com.example.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;

public final class TraceValve extends ValveBase {
    private static final Logger log = LoggerFactory.getLogger(TraceValve.class);
    private final String where;

    public TraceValve(String where) { this.where = where; }

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        long start = System.nanoTime();
        try {
            log.info("[Valve:BEGIN] where={} method={} uri={}", where,
                    request.getMethod(), request.getRequestURI());
            Valve next = getNext();
            if (next != null) next.invoke(request, response);
        } finally {
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
            log.info("[Valve:END]   where={} status={} tookMs={}", where,
                    response.getStatus(), tookMs);
        }
    }
}