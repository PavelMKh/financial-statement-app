package com.pavelkhomenko.financialstatementapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company_overview")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    private String ticker;
    @Column(name = "name")
    private String companyName;
    @Column(name = "description")
    private String description;
    @Column(name = "country")
    private String country;
    @Column(name = "sector")
    private String sector;
    @Column(name = "industry")
    private String industry;
    @Column(name = "address")
    private String adress;
}
