/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pavelkhomenko.financialstatementapp.repository;

import com.pavelkhomenko.financialstatementapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavel
 */
@Repository
public interface CorporateInformationRepository extends JpaRepository<Company, String> {
    Company findByTicker(String ticker);
    Company save(Company company);
}
