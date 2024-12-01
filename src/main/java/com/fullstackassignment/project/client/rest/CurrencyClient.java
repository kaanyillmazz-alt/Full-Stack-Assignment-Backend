package com.fullstackassignment.project.client.rest;

import com.fullstackassignment.project.dto.GoldPriceDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Log4j2
public class CurrencyClient {
    private final RestTemplate restTemplate;

    private static final String API_URL = "https://api.gold-api.com/price/XAU";

    public GoldPriceDTO getGoldPrice() {
        try {
            return restTemplate.getForObject(API_URL, GoldPriceDTO.class);
        } catch (Exception e) {
            log.error("Error fetching gold price: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve gold price", e);
        }
    }
}