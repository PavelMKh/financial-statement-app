package com.pavelkhomenko.financialstatementapp.dto;

import com.pavelkhomenko.financialstatementapp.entity.BalanceSheet;
import com.pavelkhomenko.financialstatementapp.entity.CashFlow;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDataDto {
    private Company company;
    private List<BalanceSheet> balanceSheet;
    private List<IncomeStatement> incomeStatement;
    private List<CashFlow> cashFlow;
}
