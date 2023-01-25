package com.example.directory_country2.service;

import com.example.directory_country2.entity.Currency;
import com.example.directory_country2.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void saveAllCurrencies(List<Currency> currencies) {
        for (Currency currency : currencies) {
            if (!currencyRepository.existsByCodeIso(currency.getCodeIso())) {
                currencyRepository.save(currency);
            }
        }
    }
}
