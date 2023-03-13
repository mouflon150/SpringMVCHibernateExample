package it.kg.controllers;

import it.kg.repositories.CompanyRepository;
import it.kg.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/")
    public String findAllCompanies(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "list_companies";
    }

    @GetMapping("/findCompany/{id}")
    public String findCompanyById(Model model, @PathVariable int id) {
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "find_company";
    }

    @GetMapping("/companyForm")
    public String showCompanyForm() {
        return "add_company";
    }

    @PostMapping("/addCompany")
    private String saveCompany(@RequestParam("companyName") String companyName,
                               @RequestParam("locatedCountry") String locatedCountry) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.save(company);
        return "redirect:/";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompanyById(@PathVariable("id") int id) {
//        Company company = companyRepository.findById(id);
        companyRepository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/editCompany/{id}")
    public String editCompany(@PathVariable("id") int id, Model model) {
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "update_company";
    }

    @PostMapping("/updateCompany/{id}")
    public String updateCompany(@RequestParam("companyName") String companyName,
                                @RequestParam("locatedCountry") String locatedCountry,
                                @PathVariable("id") int id) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.update(id, company);
        return "redirect:/";
    }

    @GetMapping("/clearCompanies")
    public String clearCompanies() {
        companyRepository.clear();
        return "redirect:/";
    }
}