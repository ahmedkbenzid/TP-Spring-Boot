package com.countryservice.demo;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.CountryController;
import com.countryservice.demo.services.CountryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes= {ControllerMockitoTests.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControllerMockitoTests {
    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    public List<Country> mycountries;
    Country country;

    @Test
    @Order(1)
    public void test_getAllCountries(){
        mycountries = new ArrayList<Country>();
        mycountries.add(new Country(1,"India","Delhi"));
        mycountries.add(new Country(2,"USA","Washington"));

        when (countryService.getAllCountries()).thenReturn(mycountries);//Mocking
        ResponseEntity<List<Country>> res = countryController.getCountries();

        assertEquals(HttpStatus.FOUND, res.getStatusCode());
        assertEquals(2,res.getBody().size());
    }

}
