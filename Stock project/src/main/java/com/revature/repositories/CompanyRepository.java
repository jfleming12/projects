package com.revature.repositories;

import com.revature.models.Company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	Company findByTicker(String ticker);
	Company findById(int id);
	List<Company> findAll();
	
	List<Company> findByMcGreaterThan(double mc);
}
