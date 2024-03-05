package com.pavelkhomenko.financialstatementapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.service.CompanyDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@Validated
public class CompanyDataController {
    private final CompanyDataService companyDataService;

    @GetMapping("/{ticker}/overview")
    public Company getCompanyOverview(@PathVariable String ticker,
                                      @RequestParam("apikey") String apiKey)
            throws JsonProcessingException {
        return companyDataService.getCompanyOverview(ticker, apiKey);
    }
}
