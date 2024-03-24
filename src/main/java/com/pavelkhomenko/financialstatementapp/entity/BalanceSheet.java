package com.pavelkhomenko.financialstatementapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

        @Column(name = "longterndebtnoncurrent")
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
}
