package com.example.directory_country2.repository;

import com.example.directory_country2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country getCountriesByCodeISO(Long code);

    boolean existsByCodeISO(Long code);
}
