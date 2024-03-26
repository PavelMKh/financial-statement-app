package com.pavelkhomenko.financialstatementapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavelkhomenko.financialstatementapp.entity.Company;
import com.pavelkhomenko.financialstatementapp.entity.IncomeStatement;
import com.pavelkhomenko.financialstatementapp.repository.CompanyOverviewDao;
import com.pavelkhomenko.financialstatementapp.repository.CompanyOverviewDaoImpl;
import com.pavelkhomenko.financialstatementapp.repository.IncomeStatementDao;
import com.pavelkhomenko.financialstatementapp.repository.IncomeStatementDaoImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@JdbcTest
public class RepositoryTest {
    public static DataSource dataSource;
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static JdbcTemplate jdbcTemplate;
    public static IncomeStatementDao incomeStatementDao;
    public static CompanyOverviewDao companyOverviewDao;
    public static Company testCompany;

    @BeforeAll
    public static void createJdbcTemplate() throws IOException {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("/schema.sql")
                .build();
        jdbcTemplate = new JdbcTemplate(dataSource);
        incomeStatementDao = new IncomeStatementDaoImpl(jdbcTemplate);
        companyOverviewDao = new CompanyOverviewDaoImpl(jdbcTemplate);
        testCompany = objectMapper.readValue(
                new String(Files.readAllBytes(Paths.get("src/test/resources/overview.json"))),
                Company.class);
        companyOverviewDao.saveCompanyOverview(testCompany);
    }

    @Test
    public void getPnlTest() throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        IncomeStatement testPnl = objectMapper.readValue(
                new String(Files.readAllBytes(Paths.get("src/test/resources/pnl.json"))),
        IncomeStatement.class);
        testPnl.setId("AAPL2023-09-30");
        List<IncomeStatement> testPnlList = Collections.singletonList(testPnl);
        incomeStatementDao.savePnl(testPnlList);
        List<IncomeStatement> testPnlDb = incomeStatementDao.getPnl("AAPL");
        assertEquals(testPnlList, testPnlDb);
    }

    @Test
    public void getPnlTickerNotExistTest() {
        assertTrue(companyOverviewDao.getCompanyOverview("IBM").isEmpty());
    }

    @Test
    public void getOverviewTest() {
        Company aaplDb = companyOverviewDao.getCompanyOverview("AAPL").get();
        assertEquals(testCompany, aaplDb);
    }

    @Test
    public void getOverviewTickerNotExistTest() {
        assertEquals(companyOverviewDao.getCompanyOverview("IBM"), Optional.empty());
    }
}
