package com.pavelkhomenko.financialstatementapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pavelkhomenko.financialstatementapp.dto.CompanyDataDto;
import com.pavelkhomenko.financialstatementapp.entity.BalanceSheet;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;
import com.pavelkhomenko.financialstatementapp.mapping.BalanceSheetProcessing;
import com.pavelkhomenko.financialstatementapp.repository.BalanceSheetDao;
import com.pavelkhomenko.financialstatementapp.repository.CompanyOverviewDao;
import com.pavelkhomenko.financialstatementapp.repository.IncomeStatementDao;
import com.pavelkhomenko.financialstatementapp.mapping.CompanyOverviewProcessing;
import com.pavelkhomenko.financialstatementapp.mapping.IncomeStatementProcessing;
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
    private final BalanceSheetProcessing bsProcessing;
    private final BalanceSheetDao bsDao;

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

    public List<BalanceSheet> getBalanceSheet(String ticker, String apiKey) throws JsonProcessingException {
        List<BalanceSheet> balanceSheets = bsDao.getBalanceSheet(ticker);
        if (balanceSheets.isEmpty()) {
            balanceSheets = bsProcessing.getBsList(ticker, apiKey);
            bsDao.saveBalanceSheet(balanceSheets);
        }
        return balanceSheets;
    }

    public CompanyDataDto getAllCompanyData(String ticker, String apiKey) throws JsonProcessingException {
        return new CompanyDataDto().builder()
                .company(getCompanyOverview(ticker, apiKey))
                .incomeStatement(getIncomeStatement(ticker, apiKey))
                .balanceSheet(getBalanceSheet(ticker, apiKey))
                .build();
    }
}
