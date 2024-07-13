package com.pokeapi.abilities.utility;

import com.pokeapi.abilities.exceptions.RateLimitException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitInterceptor {

    private final Map<String, Instant> clientRequests = new ConcurrentHashMap<>();

    public void intercept(String clientId) throws RateLimitException {
        Instant lastRequestTime = clientRequests.get(clientId);
        Instant now = Instant.now();

        // Allow one request per second
        if (lastRequestTime != null && lastRequestTime.plusSeconds(1).isAfter(now)) {
            throw new RateLimitException("Rate limit exceeded. Please wait before trying again.");
        }

        clientRequests.put(clientId, now);
    }
}
