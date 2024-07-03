package com.takeaway.case_study.dto;

public class CountryRequest {
    private String name;

    public CountryRequest() {
    }

    public CountryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
