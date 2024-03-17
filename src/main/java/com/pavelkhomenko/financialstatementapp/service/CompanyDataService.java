package com.pavelkhomenko.financialstatementapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;
import com.pavelkhomenko.financialstatementapp.repository.CompanyOverviewDao;
import com.pavelkhomenko.financialstatementapp.repository.IncomeStatementDao;
import com.pavelkhomenko.financialstatementapp.util.CompanyOverviewProcessing;
import com.pavelkhomenko.financialstatementapp.util.IncomeStatementProcessing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyDataService {
    private final CompanyOverviewProcessing companyOverviewProcessing;
    private final CompanyOverviewDao companyOverviewDao;
    private final IncomeStatementProcessing pnlProcessing;
    private final IncomeStatementDao pnlDao;

    public Company getCompanyOverview(String ticker, String apiKey)
            throws JsonProcessingException {
        Optional<Company> company = companyOverviewDao.getCompanyOverview(ticker);
        if (company.isEmpty()) {
            Company companyFromAv = companyOverviewProcessing.getOverview(ticker, apiKey);
            companyOverviewDao.saveCompanyOverview(companyFromAv);
            return companyFromAv;
        }
        return company.get();
    }

    public List<IncomeStatement> getIncomeStatement(String ticker, String apiKey) throws JsonProcessingException {
        List<IncomeStatement> incomeStatements = pnlDao.getPnl(ticker);
        if (incomeStatements.isEmpty()) {
            incomeStatements = pnlProcessing.getPnlList(ticker, apiKey);
            pnlDao.savePnl(incomeStatements);
        }
        return incomeStatements;
    }
}
