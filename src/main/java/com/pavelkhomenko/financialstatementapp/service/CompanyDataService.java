package com.pavelkhomenko.financialstatementapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.repository.CorporateInformationRepository;
import com.pavelkhomenko.financialstatementapp.util.CompanyOverviewProcessing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyDataService {
    private final CompanyOverviewProcessing companyOverviewProcessing;
    private final CorporateInformationRepository corporateInformationRepository;
    public Company getCompanyOverview(String ticker, String apiKey)
            throws JsonProcessingException {
        Company company = corporateInformationRepository.findByTicker(ticker);
        if (company == null) {
            company = companyOverviewProcessing.getOverview(ticker, apiKey);
            corporateInformationRepository.save(company);
        }
        return company;
    }
}
