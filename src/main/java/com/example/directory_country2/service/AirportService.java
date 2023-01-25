package com.example.directory_country2.service;

import com.example.directory_country2.entity.Airport;
import com.example.directory_country2.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void saveAllAirports(List<Airport> airports) {
        for (Airport airport : airports) {
            if (!airportRepository.existsAirportByCodeIATA(airport.getCodeIATA())) {
                airportRepository.save(airport);
            }
        }
    }
}
