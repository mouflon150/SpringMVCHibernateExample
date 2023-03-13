package it.kg.controllers;

import it.kg.models.*;
import it.kg.repositories.GroupRepository;
import it.kg.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentsController {

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    @Autowired
    public StudentsController(StudentRepository studentRepository,
                              GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @GetMapping("/students")
    public String findAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "list_students";
    }

    @GetMapping("/findStudent/{id}")
    public String findStudentById(Model model, @PathVariable int id) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "find_student";
    }

    @GetMapping("/studentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("group", groupRepository.findAll());
        return "add_student";
    }

    @PostMapping("/addStudent")
    private String saveStudent(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("studyFormat") String studyFormat,
                               @RequestParam("id") int id) {
        Group group = groupRepository.findById(id);
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setStudyFormat(StudyFormat.valueOf(studyFormat));
        student.setGroup(group);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id) {
        Student student = studentRepository.findById(id);
        studentRepository.delete(student.getId());
        return "redirect:/students";
    }

    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("studyFormat") String studyFormat,
                                @PathVariable("id") int id) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setStudyFormat(StudyFormat.valueOf(studyFormat));
        studentRepository.update(id, student);
        return "redirect:/students";
    }

    @GetMapping("/clearStudents")
    public String clearStudents() {
        studentRepository.clear();
        return "redirect:/students";
    }
}
