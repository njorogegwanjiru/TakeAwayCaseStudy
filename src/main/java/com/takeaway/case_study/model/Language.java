package com.takeaway.case_study.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("sisocode")
    @Column(name = "iso_code")
    private String sISOCode;

    @JsonProperty("sname")
    @Column(name = "name")
    private String sName;

    @ManyToOne
    @JoinColumn(name = "country_info_id")
    private CountryInfo countryInfo;

    // Getters and Setters
}
