//package com.example.directory_country2.service;
//
//import com.example.directory_country2.entity.Airport;
//import com.example.directory_country2.repository.AirportRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class AirportServiceTest {
//    @Mock
//    private AirportService airportService;
//    private AirportRepository airportRepository;
//    @BeforeAll
//    public setUp() {
//
//    }
//
//    @Test
//    void shouldSaveAirportsWhenWeHaveListOfAirports() {
//        ArrayList<Airport> expectedListAirports = new ArrayList<>();
//        Airport expected1 = new Airport();
//        Airport expected2 = new Airport();
//        expectedListAirports.add(expected1);
//        expectedListAirports.add(expected2);
//
//        airportService.saveAllAirports(expectedListAirports);
//
//        assertEquals();
//    }
//}