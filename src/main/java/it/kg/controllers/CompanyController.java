package it.kg.controllers;

import it.kg.models.Course;
import it.kg.repositories.CompanyRepository;
import it.kg.models.Company;
import it.kg.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CompanyController {

//    private final CompanyRepository companyRepository;

    //    @Autowired
//    public CompanyController(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, CourseRepository courseRepository) {
        this.companyRepository = companyRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "companies_list";
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
    public String deleteById(@PathVariable("id") int id) {
//        Company company = companyRepository.findById(id);
        companyRepository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateCompany(@PathVariable("id") int id, Model model) {
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "update_company";
    }

        @PostMapping("/updateCompany/{id}")
    public String update(@RequestParam("companyName") String companyName,
                         @RequestParam("locatedCountry") String locatedCountry,
                         @PathVariable("id") int id) {
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