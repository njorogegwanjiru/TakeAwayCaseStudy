package com.takeaway.case_study.service;

import com.takeaway.case_study.exception.ResourceNotFoundException;
import com.takeaway.case_study.model.CountryInfo;
import com.takeaway.case_study.repository.CountryInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryInfoService  {

    private static final Logger logger = LoggerFactory.getLogger(CountryInfoService.class);

    private final CountryInfoRepository countryInfoRepository;

    @Autowired
    public CountryInfoService(CountryInfoRepository countryInfoRepository) {
        this.countryInfoRepository = countryInfoRepository;
    }

    public List<CountryInfo> getAllCountryInfo() {
        logger.info("Fetching all country information");
        return countryInfoRepository.findAll();
    }

    public Optional<CountryInfo> getCountryInfoById(Long id) {
        logger.info("Fetching country information for ID: {}", id);
        Optional<CountryInfo> countryInfo = countryInfoRepository.findById(id);
        if (countryInfo.isEmpty()) {
            logger.error("Country with ID {} not found", id);
            throw new ResourceNotFoundException("Country with ID " + id + " not found");
        }
        return countryInfo;
    }

    public CountryInfo saveCountryInfo(CountryInfo countryInfo) {
        logger.info("Saving country information: {}", countryInfo);
        return countryInfoRepository.save(countryInfo);
    }

    public boolean deleteCountryInfo(Long id) {
        logger.info("Deleting country information for ID: {}", id);
        Optional<CountryInfo> countryInfoOptional = countryInfoRepository.findById(id);
        if (countryInfoOptional.isPresent()) {
            countryInfoRepository.deleteById(id);
            logger.info("Country with ID {} deleted successfully", id);
            return true; // Deletion successful
        }
        logger.error("Country with ID {} not found for deletion", id);
        throw new ResourceNotFoundException("Country with ID " + id + " not found");
    }
}
