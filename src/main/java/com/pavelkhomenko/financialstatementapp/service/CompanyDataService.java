package com.pavelkhomenko.financialstatementapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.util.CompanyOverviewProcessing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyDataService {
    private final CompanyOverviewProcessing companyOverviewProcessing;
    public Company getCompanyOverview(String ticker, String apiKey)
            throws JsonProcessingException {
        return companyOverviewProcessing.getOverview(ticker, apiKey);
    }
}
