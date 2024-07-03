package com.takeaway.case_study.service;

import com.takeaway.case_study.model.CountryISOCodeResponse;
import com.takeaway.case_study.model.FullCountryInfoResponse;
import com.takeaway.case_study.soapclients.CountryClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTests {

    @Mock
    private CountryClient countryClient;

    @InjectMocks
    private CountryService countryService;

    @Test
    public void testGetCountryISOCode() {
        String countryName = "Tanzania";
        String expectedISOCode = "TZ";

        CountryISOCodeResponse mockResponse = new CountryISOCodeResponse();
        mockResponse.setCountryISOCodeResult(expectedISOCode);

        when(countryClient.getCountryISOCode(countryName)).thenReturn(mockResponse);

        String actualISOCode = countryService.getCountryISOCode(countryName);

        assertEquals(expectedISOCode, actualISOCode);
        verify(countryClient, times(1)).getCountryISOCode(countryName);
    }

    @Test
    public void testGetFullCountryInfo() {
        String isoCode = "KEN";

        FullCountryInfoResponse mockResponse = new FullCountryInfoResponse();

        when(countryClient.getFullCountryInfo(isoCode)).thenReturn(mockResponse);

        FullCountryInfoResponse actualResponse = countryService.getFullCountryInfo(isoCode);

        assertNotNull(actualResponse);

        verify(countryClient, times(1)).getFullCountryInfo(isoCode);
    }
}
