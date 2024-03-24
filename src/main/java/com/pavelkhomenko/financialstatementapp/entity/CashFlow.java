package com.pavelkhomenko.financialstatementapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class CashFlow {
    @Id
    @JsonIgnore
    @Column(name = "id")
    private String id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "fiscaldateending")
    private LocalDate fiscalDateEnding;

    @Column(name = "type")
    private String type;

    @Column(name = "reportedcurrency")
    private String reportedCurrency;

    @Column(name = "operatingcashflow")
    private Long operatingCashFlow;

    @Column(name = "paymentsforoperatingactivities")
    private Long paymentsForOperatingActivities;

    @Column(name = "proceedsfromoperatingactivities")
    private Long proceedsFromOperatingActivities;

    @Column(name = "changeinoperatingliabilities")
    private Long changeInOperatingLiabilities;

    @Column(name = "changeinoperatingassets")
    private Long changeInOperatingAssets;

    @Column(name = "depreciationdepletionandamortization")
    private Long depreciationDepletionAndAmortization;

    @Column(name = "capitalexpenditures")
    private Long capitalExpenditures;

    @Column(name = "changeinreceivables")
    private Long changeInReceivables;

    @Column(name = "changeininventory")
    private Long changeInInventory;

    @Column(name = "profitloss")
    private Long profitLoss;

    @Column(name = "cashflowfrominvestment")
    private Long cashFlowFromInvestment;

    @Column(name = "cashflowfromfinancing")
    private Long cashFlowFromFinancing;

    @Column(name = "proceedsfromrepaymentsofshorttermdet")
    private Long proceedsFromRepaymentsOfStd;

    @Column(name = "paymentsforrepurchaseofcommonstock")
    private Long paymentsForRepurchaseOfCommonStock;

    @Column(name = "paymentsforrepurchaseofequity")
    private Long paymentsForRepurchaseOfEquity;

    @Column(name = "paymentsforrepurchaseofpreferredstock")
    private Long paymentsForRepurchaseOfPreferredStock;

    @Column(name = "dividendpayout")
    private Long dividendPayout;

    @Column(name = "dividendpayoutcommonstock")
    private Long dividendPayoutCommonStock;

    @Column(name = "dividendpayoutpreferredstock")
    private Long dividendPayoutPreferredStock;

    @Column(name = "proceedsfromissuanceofcommonstock")
    private Long proceedsFromIssuanceOfCommonStock;

    @Column(name = "proceedsfromissuanceoflongtermdetandcapitalsecuritiesnet")
    private Long proceedsFromIssuanceOfLtdAndCsn;

    @Column(name = "proceedsfromissuanceofpreferredstock")
    private Long proceedsFromIssuanceOfPreferredStock;

    @Column(name = "proceedsfromrepurchaseofequity")
    private Long proceedsFromRepurchaseOfEquity;

    @Column(name = "proceedsfromsaleoftreasurystock")
    private Long proceedsFromSaleOfTreasuryStock;

    @Column(name = "changeincashandcashequivalents")
    private Long changeInCashAndCashEquivalents;

    @Column(name = "changeinexchangerate")
    private Long changeInExchangeRate;

    @Column(name = "netincome")
    private Long netIncome;
}
