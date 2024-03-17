package com.pavelkhomenko.financialstatementapp.repository;

import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;

import java.util.List;

public interface IncomeStatementDao {

    List<IncomeStatement> getPnl(String ticker);

    void savePnl(List<IncomeStatement> pnlList);
}
