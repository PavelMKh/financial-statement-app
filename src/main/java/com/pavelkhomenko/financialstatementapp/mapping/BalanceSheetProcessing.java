package com.pavelkhomenko.financialstatementapp.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavelkhomenko.financialstatementapp.entity.BalanceSheet;
import com.pavelkhomenko.financialstatementapp.util.HttpRequestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class BalanceSheetProcessing {
    private final HttpRequestClient httpRequestClient;

    @Autowired
    public BalanceSheetProcessing(HttpRequestClient httpRequestClient) {
        this.httpRequestClient = httpRequestClient;
    }

    public List<BalanceSheet> getBsList(String ticker, String apiKey) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        JsonNode bsJson = objectMapper
                .readTree(getBsJson(ticker, apiKey));
        JsonNode quarterlyReportsJson = bsJson.get("quarterlyReports");
        JsonNode annualReportsJson = bsJson.get("annualReports");
        List<BalanceSheet> quarterlyReports = StreamSupport.stream(quarterlyReportsJson.spliterator(), true)
                .parallel()
                .map(report -> {
                    BalanceSheet bs;
                    try {
                        bs = objectMapper.treeToValue(report, BalanceSheet.class);
                        bs.setType("quarter");
                        bs.setId(ticker + "BS" + bs.getFiscalDateEnding() + "quarter");
                        bs.setTicker(ticker);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return bs;
                })
                .collect(Collectors.toList());
        List<BalanceSheet> annualReports = StreamSupport.stream(annualReportsJson.spliterator(), true)
                .parallel()
                .map(report -> {
                    BalanceSheet bs;
                    try {
                        bs = objectMapper.treeToValue(report, BalanceSheet.class);
                        bs.setType("annual");
                        bs.setId(ticker + "BS" + bs.getFiscalDateEnding() + "annual");
                        bs.setTicker(ticker);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return bs;
                })
                .collect(Collectors.toList());
        List<BalanceSheet> combinedReports = new ArrayList<>();
        combinedReports.addAll(annualReports);
        combinedReports.addAll(quarterlyReports);
        return combinedReports;
    }

    private String getBsJson(String ticker, String apiKey) {
        URI uri = URI.create(
                "https://www.alphavantage.co/query?function=BALANCE_SHEET&symbol=" +
                        ticker + "&apikey="+apiKey);
        return httpRequestClient.getResponseBody(uri);
    }
}
