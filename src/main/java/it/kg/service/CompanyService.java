package it.kg.service;

import it.kg.models.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(int id);

    void save(Company company);

    void delete(int id);

    void update(int id, Company company);

    void clear();
}
