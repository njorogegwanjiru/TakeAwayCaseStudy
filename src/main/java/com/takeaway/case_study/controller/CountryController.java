package com.takeaway.case_study.controller;

import com.takeaway.case_study.dto.CountryRequest;
import com.takeaway.case_study.model.CountryInfo;
import com.takeaway.case_study.model.FullCountryInfoResponse;
import com.takeaway.case_study.service.CountryInfoService;
import com.takeaway.case_study.service.CountryService;
import com.takeaway.case_study.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CountryController {

    private final CountryService countryService;

    private final CountryInfoService countryInfoService;

    @Autowired
    public CountryController(CountryService countryService, CountryInfoService countryInfoService) {
        this.countryService = countryService;
        this.countryInfoService = countryInfoService;
    }

    // Endpoint to fetch ISO code for a country name
    @PostMapping("/iso")
    public ResponseEntity<String> getCountryIsoCode(@RequestBody CountryRequest countryRequest) {
        String countryName = StringUtils.convertToSentenceCase(countryRequest.getName());
        String isoCode = countryService.getCountryISOCode(countryName);
        return ResponseEntity.ok(isoCode);
    }

    // Endpoint to fetch full country information based on ISO code
    @PostMapping("/country")
    public ResponseEntity<FullCountryInfoResponse> getCountryInfo(@RequestBody String isoCode) {
        FullCountryInfoResponse fullCountryInfo = countryService.getFullCountryInfo(isoCode);
        return ResponseEntity.ok(fullCountryInfo);
    }

    //Fetch all countries
    @GetMapping("/countries")
    public List<CountryInfo> getAllCountryInfo() {
        return countryInfoService.getAllCountryInfo();
    }

    //Store Country item
    @PostMapping("/country/create")
    public CountryInfo createCountryInfo(@RequestBody CountryInfo countryInfo) {
        return countryInfoService.saveCountryInfo(countryInfo);
    }

    //Fetch country information by ID
    @GetMapping("/country/fetch/{id}")
    public ResponseEntity<CountryInfo> getCountryInfoById(@PathVariable Long id) {
        Optional<CountryInfo> countryInfo = countryInfoService.getCountryInfoById(id);
        return countryInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Update country information
    @PutMapping("/country/update/{id}")
    public ResponseEntity<CountryInfo> updateCountryInfo(@PathVariable Long id, @RequestBody CountryInfo updatedCountryInfo) {
        Optional<CountryInfo> existingCountryInfo = countryInfoService.getCountryInfoById(id);
        if (existingCountryInfo.isPresent()) {
            CountryInfo countryInfo = existingCountryInfo.get();
            countryInfo.setsISOCode(updatedCountryInfo.getsISOCode());
            countryInfo.setsName(updatedCountryInfo.getsName());
            countryInfo.setsCapitalCity(updatedCountryInfo.getsCapitalCity());
            countryInfo.setsPhoneCode(updatedCountryInfo.getsPhoneCode());
            countryInfo.setsContinentCode(updatedCountryInfo.getsContinentCode());
            countryInfo.setsCurrencyISOCode(updatedCountryInfo.getsCurrencyISOCode());
            countryInfo.setsCountryFlag(updatedCountryInfo.getsCountryFlag());
            countryInfo.setLanguages(updatedCountryInfo.getLanguages());
             return ResponseEntity.ok(countryInfoService.saveCountryInfo(countryInfo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete country information
    @DeleteMapping("/country/delete/{id}")
    public ResponseEntity<String> deleteCountryInfo(@PathVariable Long id) {
        boolean deleted = countryInfoService.deleteCountryInfo(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Country with ID " + id + " not found");
        }
    }

}
