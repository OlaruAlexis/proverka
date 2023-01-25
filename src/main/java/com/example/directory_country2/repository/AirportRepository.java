package com.example.directory_country2.repository;

import com.example.directory_country2.entity.Airport;
import com.example.directory_country2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {

    Airport getAirportByCodeIATA(String code);

    boolean existsAirportByCodeIATA(String code);


}
