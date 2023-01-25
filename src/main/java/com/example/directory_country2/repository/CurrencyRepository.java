package com.example.directory_country2.repository;

import com.example.directory_country2.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency getCurrenciesByCodeIso(Long code);

    boolean existsByCodeIso(Long code);
}
