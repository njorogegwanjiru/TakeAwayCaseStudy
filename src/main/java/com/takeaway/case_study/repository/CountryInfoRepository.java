package com.takeaway.case_study.repository;

import com.takeaway.case_study.model.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryInfoRepository extends JpaRepository<CountryInfo, Long> {
}
