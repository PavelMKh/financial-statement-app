package com.pavelkhomenko.financialstatementapp.dto;

import com.pavelkhomenko.financialstatementapp.entity.BalanceSheet;
import com.pavelkhomenko.financialstatementapp.entity.CashFlow;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDataDto {
    private Company company;
    private BalanceSheet balanceSheet;
    private IncomeStatement incomeStatement;
    private CashFlow cashFlow;
}
