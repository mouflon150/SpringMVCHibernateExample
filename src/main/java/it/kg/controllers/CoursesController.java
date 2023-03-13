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
public class CoursesController {

    private final CourseRepository courseRepository;

    private final CompanyRepository companyRepository;

    @Autowired
    public CoursesController(CourseRepository courseRepository,
                             CompanyRepository companyRepository) {
        this.courseRepository = courseRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/courses")
    public String findAllCourses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "list_courses";
    }

    @GetMapping("/findCourse/{id}")
    public String findCourseById(Model model, @PathVariable int id) {
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "find_course";
    }

    @GetMapping("/courseForm")
    public String showCourseForm(Model model) {
        model.addAttribute("company", companyRepository.findAll());
        return "add_course";
    }

    @PostMapping("/addCourse")
    private String saveCourse(@RequestParam("courseName") String courseName,
                              @RequestParam("duration") String duration,
                              @RequestParam("id") int id) {
        Company company = companyRepository.findById(id);
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setCompany(company);
        courseRepository.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourseById(@PathVariable int id) {
        Course course = courseRepository.findById(id);
        courseRepository.delete(course.getId());
        return "redirect:/courses";
    }

    @GetMapping("/editCourse/{id}")
    public String editCourse(@PathVariable("id") int id, Model model) {
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "update_course";
    }

    @PostMapping("/updateCourse/{id}")
    public String updateCourse(@RequestParam("courseName") String courseName,
                               @RequestParam("duration") String duration,
                               @PathVariable("id") int id) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseRepository.update(id, course);
        return "redirect:/courses";
    }

    @GetMapping("/clearCourses")
    public String clearCourses() {
        courseRepository.clear();
        return "redirect:/courses";
    }
}