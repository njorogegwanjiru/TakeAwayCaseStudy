package com.takeaway.case_study.repository;

import com.takeaway.case_study.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
