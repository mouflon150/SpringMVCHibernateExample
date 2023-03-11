package it.kg.controllers;

import it.kg.models.Company;
import it.kg.models.Course;
import it.kg.repositories.CompanyRepository;
import it.kg.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public CoursesController(CourseRepository courseRepository, CompanyRepository companyRepository) {
        this.courseRepository = courseRepository;
        this.companyRepository = companyRepository;
    }


    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "courses_list";
    }

    @GetMapping("/findCourse/{id}")
    public String findById(Model model, @PathVariable int id) {
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "find_course";
    }

    //    @GetMapping("/courseForm")
//    public String showForm() {
//        return "add_course";
//    }
    @GetMapping("/courseForm")
    public String showForm(Model model) {
        model.addAttribute("companyId", companyRepository.findAll());
        return "add_course";
    }

    //    @PostMapping("/addCourse")
//    private String save(@RequestParam("courseName") String courseName,
//                        @RequestParam("duration") String duration) {
//        Course course = new Course();
//        course.setCourseName(courseName);
//        course.setDuration(duration);
//        courseRepository.save(course);
//        return "redirect:/";
//    }
    @PostMapping("/addCourse")
    private String save(@RequestParam("courseName") String courseName,
                        @RequestParam("duration") String duration,
                        @RequestParam("id") int id) {
        Company company = companyRepository.findById(id);
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setCompany(company);
        courseRepository.save(course);
        return "redirect:/";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteById(@PathVariable int id) {
        Course course = courseRepository.findById(id);
        courseRepository.delete(course.getId());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateCourse(@PathVariable("id") int id, Model model) {
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "update_course";
    }

    @PostMapping("/updateCourse/{id}")
    public String update(@RequestParam("corseName") String courseName,
                         @RequestParam("duration") String duration,
                         @PathVariable("id") int id) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseRepository.update(id, course);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        courseRepository.clear();
        return "redirect:/";
    }
}