package com.takeaway.case_study.repository;

import com.takeaway.case_study.model.CountryInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryInfoRepositoryTests {

    @Autowired
    private CountryInfoRepository countryInfoRepository;

    @Test
    public void testFindAll() {
        List<CountryInfo> countries = countryInfoRepository.findAll();
        assertEquals(1, countries.size());
    }
}
