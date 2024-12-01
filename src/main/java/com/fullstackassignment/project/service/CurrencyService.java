package com.fullstackassignment.project.service;

import com.fullstackassignment.project.client.rest.CurrencyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyClient currencyClient;

    public BigDecimal getGoldPrice() {
        return currencyClient.getGoldPrice().getPrice();
    }

}