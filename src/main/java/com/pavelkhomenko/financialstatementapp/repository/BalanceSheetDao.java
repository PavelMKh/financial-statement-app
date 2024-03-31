package com.pavelkhomenko.financialstatementapp.repository;

import com.pavelkhomenko.financialstatementapp.entity.BalanceSheet;

import java.util.List;

public interface BalanceSheetDao {
    List<BalanceSheet> getBalanceSheet(String ticker);

    void saveBalanceSheet(List<BalanceSheet> balanceSheet);
}
