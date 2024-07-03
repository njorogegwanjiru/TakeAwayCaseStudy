package com.takeaway.case_study.soapclients;

import com.takeaway.case_study.model.CountryISOCode;
import com.takeaway.case_study.model.CountryISOCodeResponse;
import com.takeaway.case_study.model.FullCountryInfo;
import com.takeaway.case_study.model.FullCountryInfoResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class CountryClient extends WebServiceGatewaySupport {
//
    public CountryISOCodeResponse getCountryISOCode(String countryName) {
        CountryISOCode request = new CountryISOCode();
        request.setSCountryName(countryName);

        // Send SOAP request and receive response
        CountryISOCodeResponse response = (CountryISOCodeResponse) getWebServiceTemplate().marshalSendAndReceive(
                request);

        if (response != null) {
            return response;
        } else {
            throw new RuntimeException("No ISO code found for country: " + countryName);
        }
    }
//
    public FullCountryInfoResponse getFullCountryInfo(String isoCode) {
        FullCountryInfo request = new FullCountryInfo();
        request.setSCountryISOCode(isoCode);

        // Send SOAP request and receive response
        FullCountryInfoResponse response = (FullCountryInfoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request);

        if (response != null) {
            return response;
        } else {
            throw new RuntimeException("No full country info found for ISO code: " + isoCode);
        }
    }
}
