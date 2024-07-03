package com.takeaway.case_study.service;

import com.takeaway.case_study.exception.ResourceNotFoundException;
import com.takeaway.case_study.model.CountryInfo;
import com.takeaway.case_study.repository.CountryInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CountryInfoServiceTests {

    @Mock
    private CountryInfoRepository countryInfoRepository;

    @InjectMocks
    private CountryInfoService countryInfoService;

    @Test
    public void testGetAllCountryInfo() {
        CountryInfo countryInfo1 = new CountryInfo();
        countryInfo1.setsISOCode("KE");
        countryInfo1.setsName("Kenya");

        CountryInfo countryInfo2 = new CountryInfo();
        countryInfo2.setsISOCode("TZ");
        countryInfo2.setsName("Tanzania");

        when(countryInfoRepository.findAll()).thenReturn(List.of(countryInfo1, countryInfo2));

        List<CountryInfo> countries = countryInfoService.getAllCountryInfo();

        assertEquals(2, countries.size());
        assertEquals("KE", countries.get(0).getsISOCode());
        assertEquals("Kenya", countries.get(0).getsName());
        assertEquals("TZ", countries.get(1).getsISOCode());
        assertEquals("Tanzania", countries.get(1).getsName());
    }

    @Test
    public void testGetCountryInfoById() {
        Long id = 1L;
        CountryInfo mockCountryInfo = new CountryInfo();
        mockCountryInfo.setsISOCode("TZ");
        mockCountryInfo.setsName("Tanzania");

        when(countryInfoRepository.findById(id)).thenReturn(Optional.of(mockCountryInfo));

        Optional<CountryInfo> countryInfo = countryInfoService.getCountryInfoById(id);

        assertTrue(countryInfo.isPresent());
        assertEquals("TZ", countryInfo.get().getsISOCode());
        assertEquals("Tanzania", countryInfo.get().getsName());
    }

    @Test
    public void testGetCountryInfoByIdNotFound() {
        Long id = 1L;

        when(countryInfoRepository.findById(id)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            countryInfoService.getCountryInfoById(id);
        });

        assertEquals("Country with ID 1 not found", exception.getMessage());
    }

    @Test
    public void testSaveCountryInfo() {
        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setsISOCode("UG");
        countryInfo.setsName("Uganda");

        when(countryInfoRepository.save(countryInfo)).thenReturn(countryInfo);

        CountryInfo savedCountryInfo = countryInfoService.saveCountryInfo(countryInfo);

        assertEquals("UG", savedCountryInfo.getsISOCode());
        assertEquals("Uganda", savedCountryInfo.getsName());
    }

    @Test
    public void testDeleteCountryInfo() {
        Long id = 1L;
        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setsISOCode("UG");
        countryInfo.setsName("Uganda");

        when(countryInfoRepository.findById(id)).thenReturn(Optional.of(countryInfo));

        boolean deleted = countryInfoService.deleteCountryInfo(id);

        assertTrue(deleted);
        verify(countryInfoRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteCountryInfoNotFound() {
        Long id = 1L;

        when(countryInfoRepository.findById(id)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            countryInfoService.deleteCountryInfo(id);
        });

        assertEquals("Country with ID 1 not found", exception.getMessage());
    }
}
