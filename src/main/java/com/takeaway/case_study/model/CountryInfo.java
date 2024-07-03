package com.takeaway.case_study.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "country_info")

public class CountryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("sisocode")
    @Column(name = "iso_code")
    private String sISOCode;

    @JsonProperty("sname")
    @Column(name = "name")
    private String sName;

    @JsonProperty("scapitalCity")
    @Column(name = "capital_city")
    private String sCapitalCity;

    @JsonProperty("sphoneCode")
    @Column(name = "phone_code")
    private String sPhoneCode;

    @JsonProperty("scontinentCode")
    @Column(name = "continent_code")
    private String sContinentCode;

    @JsonProperty("scurrencyISOCode")
    @Column(name = "currency_iso_code")
    private String sCurrencyISOCode;

    @JsonProperty("scountryFlag")
    @Column(name = "country_flag")
    private String sCountryFlag;

    @JsonProperty("languages")
    @OneToMany(mappedBy = "countryInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> languages;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsISOCode() {
        return sISOCode;
    }

    public void setsISOCode(String sISOCode) {
        this.sISOCode = sISOCode;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsCapitalCity() {
        return sCapitalCity;
    }

    public void setsCapitalCity(String sCapitalCity) {
        this.sCapitalCity = sCapitalCity;
    }

    public String getsPhoneCode() {
        return sPhoneCode;
    }

    public void setsPhoneCode(String sPhoneCode) {
        this.sPhoneCode = sPhoneCode;
    }

    public String getsContinentCode() {
        return sContinentCode;
    }

    public void setsContinentCode(String sContinentCode) {
        this.sContinentCode = sContinentCode;
    }

    public String getsCurrencyISOCode() {
        return sCurrencyISOCode;
    }

    public void setsCurrencyISOCode(String sCurrencyISOCode) {
        this.sCurrencyISOCode = sCurrencyISOCode;
    }

    public String getsCountryFlag() {
        return sCountryFlag;
    }

    public void setsCountryFlag(String sCountryFlag) {
        this.sCountryFlag = sCountryFlag;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}