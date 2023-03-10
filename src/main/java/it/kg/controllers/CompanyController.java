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
    model.addAttribute("all", companyRepository.findAll());
        return "companymainpage";
    }

    @PostMapping("/saveCompany")
    private String saveCompany(@RequestParam("companyName") String companyName, @RequestParam("locatedCountry") String locatedCountry) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.save(company);
        return "redirect:/";
    }

    @GetMapping("/companyForm")
    public String saveCompanyPage() {
        return "company-save";
    }


    @GetMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable int id) {
        Company company = companyRepository.findById(id);
        companyRepository.delete(company.getId());
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public String getById(Model model, @PathVariable int id) {
        Company company = companyRepository.findById(id);
        model.addAttribute("person", company);
        return "find";
    }

    @GetMapping("/update/{id}")
    public String updatePersonForm(@PathVariable("id") int id, Model model) {
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "update-company-form";
    }

    @PostMapping("/real/update/{id}")
    public String updateCompany(@RequestParam("companyName") String companyName, @RequestParam("locatedCountry") String locatedCountry, @PathVariable int id) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepository.updateCompany(id, company);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        companyRepository.clear();
        return "redirect:/";
    }
}