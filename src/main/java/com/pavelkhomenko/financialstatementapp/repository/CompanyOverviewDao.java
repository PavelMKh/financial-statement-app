package com.pavelkhomenko.financialstatementapp.repository;

import com.pavelkhomenko.financialstatementapp.entity.Company;

import java.util.Optional;

public interface CompanyOverviewDao {
    Optional<Company> getCompanyOverview(String ticker);

    void saveCompanyOverview(Company company);
}
