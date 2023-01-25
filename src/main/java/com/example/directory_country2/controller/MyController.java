package com.example.directory_country2.controller;

import com.example.directory_country2.entity.Airport;
import com.example.directory_country2.entity.Country;
import com.example.directory_country2.entity.Currency;
import com.example.directory_country2.service.AirportService;
import com.example.directory_country2.service.CountryService;
import com.example.directory_country2.service.CurrencyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    private final CountryService countryService;

    private final AirportService airportService;

    private final CurrencyService currencyService;

    @Autowired
    public MyController(CountryService countryService, AirportService airportService, CurrencyService currencyService) {
        this.countryService = countryService;
        this.airportService = airportService;
        this.currencyService = currencyService;
    }

    public static Elements getElements(String URL) throws IOException {
        Document page = Jsoup.parse(new URL(URL), 3000);
        Elements elements = page.select("tbody").first().select("td");
        return elements;
    }

    @RequestMapping("/saveAllCountriesWithCodes")
    public List<Country> saveAllCountries() throws IOException {
        String URL = "https://www.artlebedev.ru/country-list/";
        Elements codesAndNames = getElements(URL);
        String country = null;
        Long code;
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i <= codesAndNames.size(); i++) {
            if (i % 8 == 2) {
                country = codesAndNames.get(i).text();
            }
            if (i % 8 == 5) {
                code = Long.parseLong(codesAndNames.get(i).text());
                countries.add(new Country(code, country));
            }
        }

        countryService.saveAllCountries(countries);
        return countries;
    }

    @RequestMapping("/saveAllAirports")
    public List<Airport> saveAllAirports() {
        ArrayList<Airport> airports = new ArrayList<>();
        File file = new File("src/apinfo.ru.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[|]");
                airports.add(new Airport(words[0], words[2], words[4]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        airportService.saveAllAirports(airports);
        return airports;
    }

    @RequestMapping("/saveAllCurrencies")
    public List<Currency> saveAllCurrencies() throws IOException {
        String URL = "https://www.iban.com/currency-codes";
        Elements codesAndNames = getElements(URL);
        List<Currency> currencies = new ArrayList<>();
        Long code;
        String name = null;
        String nameOfCountry = null;
        for (int i = 0; i < codesAndNames.size(); i++) {
            if (i == 32 || i == 33 || i == 34 || i == 35 || i == 728 || i == 729 || i == 730 ||
                    i == 731 || i == 884 || i == 885 || i == 886 || i == 887) {
                continue;
            }
            if (i % 4 == 0) {
                nameOfCountry = codesAndNames.get(i).text();
            }
            if (i % 4 == 1) {
                name = codesAndNames.get(i).text();
            }
            if (i % 4 == 3) {
                code = Long.parseLong(codesAndNames.get(i).text());
                currencies.add(new Currency(code, name, nameOfCountry));
            }

        }
        currencyService.saveAllCurrencies(currencies);
        return currencies;
    }
}
