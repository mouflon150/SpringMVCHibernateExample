package it.kg.service.impl;

import it.kg.models.Company;
import it.kg.repositories.CompanyRepository;
import it.kg.repositories.impl.CompanyRepositoryImpl;
import it.kg.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void delete(int id) {
        companyRepository.delete(id);
    }

    @Override
    public void update(int id, Company company) {
        companyRepository.update(id, company);
    }

    @Override
    public void clear() {
        companyRepository.clear();
    }
}
