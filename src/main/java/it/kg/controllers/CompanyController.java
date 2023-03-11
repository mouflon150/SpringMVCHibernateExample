package it.kg.controllers;

import it.kg.repositories.CompanyRepository;
import it.kg.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "company_list";
    }

    @GetMapping("/findCompany/{id}")
    public String findById(Model model, @PathVariable int id) {
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "find_company";
    }

    @GetMapping("/companyForm")
    public String showForm() {
        return "add_company";
    }

    @PostMapping("/addCompany")
    private String save(@RequestParam("companyName") String companyName,
                        @RequestParam("locatedCountry") String locatedCountry) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.save(company);
        return "redirect:/";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable int id) {
        Company company = companyRepository.findById(id);
        companyRepository.delete(company.getId());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateCompany(@PathVariable("id") int id, Model model) {
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "update_company";
    }

    @PostMapping("/updateCompany")
    public String update(@RequestParam("companyName") String companyName,
                         @RequestParam("locatedCountry") String locatedCountry, @PathVariable int id) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.update(id, company);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        companyRepository.clear();
        return "redirect:/";
    }
}