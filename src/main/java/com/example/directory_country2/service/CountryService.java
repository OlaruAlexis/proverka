package com.example.directory_country2.service;

import com.example.directory_country2.entity.Country;
import com.example.directory_country2.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void saveAllCountries(List<Country> countries) {
        for(Country country : countries) {
            if(!countryRepository.existsByCodeISO(country.getCodeISO())) {
                countryRepository.save(country);
            }
        }
    }
}
