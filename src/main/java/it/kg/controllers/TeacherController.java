package it.kg.controllers;

import it.kg.repositories.TeacherRepository;

public class TeacherController {
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
}
//    @GetMapping("/")
//    public String findAll(Model model) {
//        model.addAttribute("companies", teacherRepository.findAll());
//        return "find companies";
//    }
//
//    @PostMapping("/saveTeacher")
//    private String saveTeacher(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
//        Teacher teacher = new Teacher();
//        teacher.setFirstName(firstName);
//        teacher.setLastName(lastName);
//        teacherRepository.save(teacher);
//        return "redirect:/";
//    }
//
//    @GetMapping("/teacherForm")
//    public String saveTeacherPage() {
//        return "teacher-save";
//    }
//
//
//    @GetMapping("/deleteTeacher/{id}")
//    public String deleteById(@PathVariable int id) {
//        Teacher teacher = teacherRepository.findById(id);
//        teacherRepository.delete(teacher.getId());
//        return "redirect:/";
//    }
//
//    @GetMapping("/get/by/{id}")
//    public String getById(Model model, @PathVariable int id) {
//        Teacher teacher = teacherRepository.findById(id);
//        model.addAttribute("teacher", teacher);
//        return "find";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateTeacherForm(@PathVariable("id") int id, Model model) {
//        Teacher teacher = teacherRepository.findById(id);
//        model.addAttribute("teacher", teacher);
//        return "update-teacher-form";
//    }
//
//    @PostMapping("/real/update/{id}")
//    public String updateTeacher(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @PathVariable int id) {
//        Teacher teacher = new Teacher();
//        teacher.setFirstName(firstName);
//        teacher.setLastName(lastName);
//        teacherRepository.updateTeacher(id, teacher);
//        return "redirect:/";
//    }
//
//    @GetMapping("/clear")
//    public String clear() {
//        teacherRepository.clear();
//        return "redirect:/";
//    }
//}
