/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavelkhomenko.financialstatementapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "income_statement")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatement {
    @Id
    private String ticker;
    @Column(name = "fiscaldateending")
    private LocalDate fiscalDateEnding;
    @Column(name = "reportedcurrency")
    private String reportedCurrency;
    @Column(name = "grossprofit")
    private long grossProfit;
    @Column(name = "costofrevenue")
    private long costOfRevenue;
    @Column(name = "costofgoodsandservicessold")
    private long costofGoodsAndServicesSold;
    @Column(name = "operatingincome")
    private long operatingIncome;
    @Column(name = "sellinggeneralandadministrative")
    private long sellingGeneralAndAdministrative;
    @Column(name = "researchanddevelopment")
    private long researchAndDevelopment;
    @Column(name = "operatingexpenses")
    private long operatingExpenses;
    @Column(name = "investmentincomenet")
    private long investmentIncomeNet;
    @Column(name = "netinterestincome")
    private long netInterestIncome;
    @Column(name = "interestincome")
    private long interestIncome;
    @Column(name = "interestexpense")
    private long interestExpense;
    @Column(name = "noninterestincome")
    private long nonInterestIncome;
    @Column(name = "othernonoperatingincome")
    private long otherNonOperatingIncome;
    @Column(name = "depreciation")
    private long depreciation;
    @Column(name = "depreciationandamortization")
    private long depreciationAndAmortization;
    @Column(name = "incomebeforetax")
    private long incomeBeforeTax;
    @Column(name = "incometaxexpense")
    private long incomeTaxExpense;
    @Column(name = "interestanddebtexpense")
    private long interestAndDebtExpense;
    @Column(name = "netincomefromcontinuingoperations")
    private long netIncomeFromContinuingOperations;
    @Column(name = "comprehensiveincomenetoftax")
    private long comprehensiveIncomeNetOfTax;
    @Column(name = "ebit")
    private long ebit;
    @Column(name = "ebitda")
    private long ebitda;
    @Column(name = "netincome")
    private long netIncome;
}
