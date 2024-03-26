package com.pavelkhomenko.financialstatementapp.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "balance_sheet")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceSheet {
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

        @Column(name = "totalassets")
        private Long totalAssets;

        @Column(name = "totalcurrentassets")
        private Long totalCurrentAssets;

        @Column(name = "cashandcashequivalentsatcarryingvalue")
        private Long cashAndCashEquivalentsAtCarryingValue;

        @Column(name = "cashandshortterminvestments")
        private Long cashAndShortTermInvestments;

        @Column(name = "inventory")
        private Long inventory;

        @Column(name = "currentnetreceivables")
        private Long currentNetReceivables;

        @Column(name = "totalnoncurrentassets")
        private Long totalNonCurrentAssets;

        @Column(name = "propertyplantequipment")
        private Long propertyPlantEquipment;

        @Column(name = "accumulateddepreciationamortizationppe")
        private Long accumulatedDepreciationAmortizationPPE;

        @Column(name = "intangibleassets")
        private Long intangibleAssets;

        @Column(name = "intangibleassetsexcludinggoodwill")
        private Long intangibleAssetsExcludingGoodwill;

        @Column(name = "goodwill")
        private Long goodwill;

        @Column(name = "investments")
        private Long investments;

        @Column(name = "longterminvestments")
        private Long longTermInvestments;

        @Column(name = "shortterminvestments")
        private Long shortTermInvestments;

        @Column(name = "othercurrentassets")
        private Long otherCurrentAssets;

        @Column(name = "othernoncurrentassets")
        private Long otherNonCurrentAssets;

        @Column(name = "totalliabilities")
        private Long totalLiabilities;

        @Column(name = "totalcurrentliabilities")
        private Long totalCurrentLiabilities;

        @Column(name = "currentaccountspayable")
        private Long currentAccountsPayable;

        @Column(name = "deferredrevenue")
        private Long deferredRevenue;

        @Column(name = "currentdebt")
        private Long currentDebt;

        @Column(name = "shorttermdebt")
        private Long shortTermDebt;

        @Column(name = "totalnoncurrentliabilities")
        private Long totalNonCurrentLiabilities;

        @Column(name = "capitalleaseobligations")
        private Long capitalLeaseObligations;

        @Column(name = "longtermdebt")
        private Long longTermDebt;

        @Column(name = "currentlongtermdebt")
        private Long currentLongTermDebt;

        @Column(name = "longtermdebtnoncurrent")
        private Long longTermDebtNonCurrent;

        @Column(name = "shortlongtermdettotal")
        private Long shortLongTermDebtTotal;

        @Column(name = "othercurrentliabilities")
        private Long otherCurrentLiabilities;

        @Column(name = "othernoncurrentliabilities")
        private Long otherNonCurrentLiabilities;

        @Column(name = "totalshareholderequity")
        private Long totalShareholderEquity;

        @Column(name = "treasurystock")
        private Long treasuryStock;

        @Column(name = "retainedearnings")
        private Long retainedEarnings;

        @Column(name = "commonstock")
        private Long commonStock;

        @Column(name = "commonstocksharesoutstanding")
        private Long commonStockSharesOutstanding;

        @JsonCreator
        public BalanceSheet(String ticker,
                            String type,
                            @JsonProperty("fiscalDateEnding") LocalDate fiscalDateEnding,
                            @JsonProperty("reportedCurrency") String reportedCurrency,
                            @JsonProperty("totalAssets") Long totalAssets,
                            @JsonProperty("totalCurrentAssets") Long totalCurrentAssets,
                            @JsonProperty("cashAndCashEquivalentsAtCarryingValue") Long cashAndCashEquivalentsAtCarryingValue,
                            @JsonProperty("cashAndShortTermInvestments") Long cashAndShortTermInvestments,
                            @JsonProperty("inventory") Long inventory,
                            @JsonProperty("currentNetReceivables") Long currentNetReceivables,
                            @JsonProperty("totalNonCurrentAssets") Long totalNonCurrentAssets,
                            @JsonProperty("propertyPlantEquipment") Long propertyPlantEquipment,
                            @JsonProperty("accumulatedDepreciationAmortizationPPE") Long accumulatedDepreciationAmortizationPPE,
                            @JsonProperty("intangibleAssets") Long intangibleAssets,
                            @JsonProperty("intangibleAssetsExcludingGoodwill") Long intangibleAssetsExcludingGoodwill,
                            @JsonProperty("goodwill") Long goodwill,
                            @JsonProperty("investments") Long investments,
                            @JsonProperty("longTermInvestments") Long longTermInvestments,
                            @JsonProperty("shortTermInvestments") Long shortTermInvestments,
                            @JsonProperty("otherCurrentAssets") Long otherCurrentAssets,
                            @JsonProperty("otherNonCurrentAssets") Long otherNonCurrentAssets,
                            @JsonProperty("totalLiabilities") Long totalLiabilities,
                            @JsonProperty("totalCurrentLiabilities") Long totalCurrentLiabilities,
                            @JsonProperty("currentAccountsPayable") Long currentAccountsPayable,
                            @JsonProperty("deferredRevenue") Long deferredRevenue,
                            @JsonProperty("currentDebt") Long currentDebt,
                            @JsonProperty("shortTermDebt") Long shortTermDebt,
                            @JsonProperty("totalNonCurrentLiabilities") Long totalNonCurrentLiabilities,
                            @JsonProperty("capitalLeaseObligations") Long capitalLeaseObligations,
                            @JsonProperty("longTermDebt") Long longTermDebt,
                            @JsonProperty("currentLongTermDebt") Long currentLongTermDebt,
                            @JsonProperty("longTermDebtNonCurrent") Long longTermDebtNonCurrent,
                            @JsonProperty("shortLongTermDebtTotal") Long shortLongTermDebtTotal,
                            @JsonProperty("otherCurrentLiabilities") Long otherCurrentLiabilities,
                            @JsonProperty("otherNonCurrentLiabilities") Long otherNonCurrentLiabilities,
                            @JsonProperty("totalShareholderEquity") Long totalShareholderEquity,
                            @JsonProperty("treasuryStock") Long treasuryStock,
                            @JsonProperty("retainedEarnings") Long retainedEarnings,
                            @JsonProperty("commonStock") Long commonStock,
                            @JsonProperty("commonStockSharesOutstanding") Long commonStockSharesOutstanding) {
                this.id = ticker + "BS" + fiscalDateEnding + type;
                this.ticker = ticker;
                this.type = type;
                this.fiscalDateEnding = fiscalDateEnding;
                this.reportedCurrency = reportedCurrency;
                this.totalAssets = totalAssets;
                this.totalCurrentAssets = totalCurrentAssets;
                this.cashAndCashEquivalentsAtCarryingValue = cashAndCashEquivalentsAtCarryingValue;
                this.cashAndShortTermInvestments = cashAndShortTermInvestments;
                this.inventory = inventory;
                this.currentNetReceivables = currentNetReceivables;
                this.totalNonCurrentAssets = totalNonCurrentAssets;
                this.propertyPlantEquipment = propertyPlantEquipment;
                this.accumulatedDepreciationAmortizationPPE = accumulatedDepreciationAmortizationPPE;
                this.intangibleAssets = intangibleAssets;
                this.intangibleAssetsExcludingGoodwill = intangibleAssetsExcludingGoodwill;
                this.goodwill = goodwill;
                this.investments = investments;
                this.longTermInvestments = longTermInvestments;
                this.shortTermInvestments = shortTermInvestments;
                this.otherCurrentAssets = otherCurrentAssets;
                this.otherNonCurrentAssets = otherNonCurrentAssets;
                this.totalLiabilities = totalLiabilities;
                this.totalCurrentLiabilities = totalCurrentLiabilities;
                this.currentAccountsPayable = currentAccountsPayable;
                this.deferredRevenue = deferredRevenue;
                this.currentDebt = currentDebt;
                this.shortTermDebt = shortTermDebt;
                this.totalNonCurrentLiabilities = totalNonCurrentLiabilities;
                this.capitalLeaseObligations = capitalLeaseObligations;
                this.longTermDebt = longTermDebt;
                this.currentLongTermDebt = currentLongTermDebt;
                this.longTermDebtNonCurrent = longTermDebtNonCurrent;
                this.shortLongTermDebtTotal = shortLongTermDebtTotal;
                this.otherCurrentLiabilities = otherCurrentLiabilities;
                this.otherNonCurrentLiabilities = otherNonCurrentLiabilities;
                this.totalShareholderEquity = totalShareholderEquity;
                this.treasuryStock = treasuryStock;
                this.retainedEarnings = retainedEarnings;
                this.commonStock = commonStock;
                this.commonStockSharesOutstanding = commonStockSharesOutstanding;
        }
}
