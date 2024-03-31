package com.pavelkhomenko.financialstatementapp.repository;

import com.pavelkhomenko.financialstatementapp.entity.CashFlow;

import java.util.List;

public interface CashFlowDao {
    List<CashFlow> getCf(String ticker);

    void saveCf(List<CashFlow> cfList);
}
