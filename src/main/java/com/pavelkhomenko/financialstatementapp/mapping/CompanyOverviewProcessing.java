package com.pavelkhomenko.financialstatementapp.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import java.net.URI;

import com.pavelkhomenko.financialstatementapp.util.HttpRequestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyOverviewProcessing {
    private final HttpRequestClient client;

    public Company getOverview(String ticker, String apiKey)
            throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode companyJson = objectMapper.readTree(getOverviewJson(ticker,
                apiKey));
        return Company.builder()
                .ticker(ticker)
                .companyName(companyJson.get("Name").asText())
                .adress(companyJson.get("Address").asText())
                .country(companyJson.get("Country").asText())
                .description(companyJson.get("Description").asText())
                .sector(companyJson.get("Sector").asText())
                .industry(companyJson.get("Industry").asText())
                .build();
    }

    private String getOverviewJson(String ticker, String apiKey) {
        URI uri = URI.create(
                "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" +
                        ticker + "&apikey="+apiKey);
        return client.getResponseBody(uri);
    }
}
