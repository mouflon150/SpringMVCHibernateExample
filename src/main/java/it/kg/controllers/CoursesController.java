package it.kg.controllers;

import it.kg.repositories.CourseRepository;

//@Controller
public class CoursesController {
    private final CourseRepository courseRepository;

    public CoursesController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
//    @GetMapping("/")
//    public String findAll(Model model) {
//        model.addAttribute("companies", courseRepository.findAll());
//        return "companymainpage";
//    }
//
//    @PostMapping("/saveCourse")
//    private String saveCompany(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration) {
//        Course course = new Course();
//        course.setCourseName(courseName);
//        course.setDuration(duration);
//        courseRepository.save(course);
//        return "redirect:/";
//    }
//
//    @GetMapping("/courseForm")
//    public String saveCoursePage() {
//        return "course-save";
//    }
//
//
//    @GetMapping("/deleteCourse/{id}")
//    public String deleteById(@PathVariable int id) {
//        Course course = courseRepository.findById(id);
//        courseRepository.delete(course.getId());
//        return "redirect:/";
//    }
//
//    @GetMapping("/get/by/{id}")
//    public String getById(Model model, @PathVariable int id) {
//        Course course = courseRepository.findById(id);
//        model.addAttribute("person", course);
//        return "find";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateCourseForm(@PathVariable("id") int id, Model model) {
//        Course course = courseRepository.findById(id);
//        model.addAttribute("person", course);
//        return "update-course-form";
//    }
//
//    @PostMapping("/real/update/{id}")
//    public String updateCourse(@RequestParam("courseName") String courseName, @RequestParam("duration") String duratiion, @PathVariable int id) {
//        Course course = new Course();
//        course.setCourseName(courseName);
//        course.setDuration(duratiion);
//        courseRepository.updateCourse(id, course);
//        return "redirect:/";
//    }
//
//    @GetMapping("/clear")
//    public String clear() {
//        courseRepository.clear();
//        return "redirect:/";
//    }
//}
