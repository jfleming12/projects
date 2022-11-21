package com.revature.services;

import com.revature.models.Company;
import com.revature.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(int id) {
        return companyRepository.findById(id);
    }

    public Company findByTicker(String ticker) {
    	return companyRepository.findByTicker(ticker);
    }

    public List<Company> findByMc(double mc){
    	return companyRepository.findByMcGreaterThan(mc);
    }
    
    public void buyStocks(Company company, double amount, int num) {
    	company.setMc(company.getMc()+(amount-company.getPricestock())*num);
    	company.setPricestock(company.getMc()/company.getNumstock());
    }

}
