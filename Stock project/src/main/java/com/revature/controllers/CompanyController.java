package com.revature.controllers;

import com.revature.models.Company;
import com.revature.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") int id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping("/ticker/{ticker}")
    public ResponseEntity<Company> getCompanyByTicker(@PathVariable("ticker") String ticker) {
        return ResponseEntity.ok(companyService.findByTicker(ticker));
    }
    
    @GetMapping("/mc/{mc}")
    public ResponseEntity<List<Company>> getCompanyByMc(@PathVariable("mc") double mc) {
        return ResponseEntity.ok(companyService.findByMc(mc));
    }
    
    @PutMapping("/buy")
    public void buyStocks(@RequestBody Company company, @RequestBody double amount, @RequestBody int num) {
    	companyService.buyStocks(company, amount, num);
    }

}
