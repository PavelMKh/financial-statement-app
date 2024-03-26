package com.pavelkhomenko.financialstatementapp.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;
import com.pavelkhomenko.financialstatementapp.util.HttpRequestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class IncomeStatementProcessing {
    private final HttpRequestClient httpRequestClient;

    @Autowired
    public IncomeStatementProcessing(HttpRequestClient httpRequestClient) {
        this.httpRequestClient = httpRequestClient;
    }

    public List<IncomeStatement> getPnlList(String ticker, String apiKey) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode incomeStatementsJson = objectMapper
                .readTree(getIncomeStatementJson(ticker, apiKey));
        JsonNode quarterlyReportsJson = incomeStatementsJson.get("quarterlyReports");
        JsonNode annualReportsJson = incomeStatementsJson.get("annualReports");
        List<IncomeStatement> quarterlyReports = StreamSupport.stream(quarterlyReportsJson.spliterator(), true)
                .parallel()
                .map(report -> buildIncomeStatementFromJson(report, ticker, "quarter"))
                .collect(Collectors.toList());
        List<IncomeStatement> annualReports = StreamSupport.stream(annualReportsJson.spliterator(), true)
                .parallel()
                .map(report -> buildIncomeStatementFromJson(report, ticker, "annual"))
                .collect(Collectors.toList());
        List<IncomeStatement> combinedReports = new ArrayList<>();
        combinedReports.addAll(annualReports);
        combinedReports.addAll(quarterlyReports);
        return combinedReports;
    }

    private String getIncomeStatementJson(String ticker, String apiKey) {
        URI uri = URI.create(
                "https://www.alphavantage.co/query?function=INCOME_STATEMENT&symbol=" +
                        ticker + "&apikey="+apiKey);
        return httpRequestClient.getResponseBody(uri);
    }

    private IncomeStatement buildIncomeStatementFromJson(JsonNode jsonNode, String ticker, String type) {
        return new IncomeStatement().builder()
                .id(ticker + "PNL" + jsonNode.get("fiscalDateEnding").asText() + type)
                .ticker(ticker)
                .type(type)
                .fiscalDateEnding(LocalDate.parse(jsonNode.get("fiscalDateEnding").asText()))
                .reportedCurrency(jsonNode.get("reportedCurrency").asText())
                .grossProfit(parseLongValue(jsonNode, "grossProfit"))
                .totalRevenue(parseLongValue(jsonNode, "totalRevenue"))
                .costOfRevenue(parseLongValue(jsonNode, "costOfRevenue"))
                .costofGoodsAndServicesSold(parseLongValue(jsonNode, "costofGoodsAndServicesSold"))
                .operatingIncome(parseLongValue(jsonNode, "operatingIncome"))
                .sellingGeneralAndAdministrative(parseLongValue(jsonNode, "sellingGeneralAndAdministrative"))
                .researchAndDevelopment(parseLongValue(jsonNode, "researchAndDevelopment"))
                .operatingExpenses(parseLongValue(jsonNode, "operatingExpenses"))
                .investmentIncomeNet(parseLongValue(jsonNode, "investmentIncomeNet"))
                .netInterestIncome(parseLongValue(jsonNode, "netInterestIncome"))
                .interestIncome(parseLongValue(jsonNode, "interestIncome"))
                .interestExpense(parseLongValue(jsonNode, "interestExpense"))
                .nonInterestIncome(parseLongValue(jsonNode, "nonInterestIncome"))
                .otherNonOperatingIncome(parseLongValue(jsonNode, "otherNonOperatingIncome"))
                .depreciation(parseLongValue(jsonNode, "depreciation"))
                .depreciationAndAmortization(parseLongValue(jsonNode, "depreciationAndAmortization"))
                .incomeBeforeTax(parseLongValue(jsonNode, "incomeBeforeTax"))
                .incomeTaxExpense(parseLongValue(jsonNode, "incomeTaxExpense"))
                .interestAndDebtExpense(parseLongValue(jsonNode, "interestAndDebtExpense"))
                .netIncomeFromContinuingOperations(parseLongValue(jsonNode, "netIncomeFromContinuingOperations"))
                .comprehensiveIncomeNetOfTax(parseLongValue(jsonNode, "comprehensiveIncomeNetOfTax"))
                .ebit(parseLongValue(jsonNode, "ebit"))
                .ebitda(parseLongValue(jsonNode, "ebitda"))
                .netIncome(parseLongValue(jsonNode, "netIncome"))
                .build();
    }

    /* If in the returned Json one of the reporting indicators is equal to "None",
    the special value -1 is returned */
    private Long parseLongValue(JsonNode jsonNode, String fieldName) {
        String value = jsonNode.get(fieldName).asText();
        return value.equals("None") ? -1 : Long.valueOf(value);
    }
}
