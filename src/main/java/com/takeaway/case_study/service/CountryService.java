package com.takeaway.case_study.service;

import com.takeaway.case_study.model.CountryISOCodeResponse;
import com.takeaway.case_study.model.FullCountryInfoResponse;
import com.takeaway.case_study.soapclients.CountryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    private final CountryClient countryClient;

    @Autowired
    public CountryService(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    public String getCountryISOCode(String countryName) {
        logger.info("Fetching ISO code for country: {}", countryName);
        CountryISOCodeResponse isoCodeResponse = countryClient.getCountryISOCode(countryName);
        String isoCode = isoCodeResponse.getCountryISOCodeResult();
        logger.info("ISO code for country {} is: {}", countryName, isoCode);
        return isoCode;
    }

    public FullCountryInfoResponse getFullCountryInfo(String isoCode) {
        logger.info("Fetching full country info for ISO code: {}", isoCode);
        FullCountryInfoResponse fullCountryInfoResponse = countryClient.getFullCountryInfo(isoCode);
        logger.info("Full country info fetched successfully for ISO code: {}", isoCode);
        return fullCountryInfoResponse;
    }

}
