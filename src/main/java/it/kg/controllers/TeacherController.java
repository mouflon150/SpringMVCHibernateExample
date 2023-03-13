package it.kg.controllers;


import it.kg.models.Course;
import it.kg.models.Teacher;
import it.kg.repositories.CourseRepository;
import it.kg.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository,
                             CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/teachers")
    public String findAllTeachers(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "list_teachers";
    }

    @GetMapping("/findTeacher/{id}")
    public String findTeacherById(Model model, @PathVariable int id) {
        Teacher teacher = teacherRepository.findById(id);
        model.addAttribute("teacher", teacher);
        return "find_teacher";
    }

    @GetMapping("/teacherForm")
    public String showTeacherForm(Model model) {
        model.addAttribute("course", courseRepository.findAll());
        return "add_teacher";
    }

    @PostMapping("/addTeacher")
    private String saveTeacher(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("id") int id) {
        Course course = courseRepository.findById(id);
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacher.setCourse(course);
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacherById(@PathVariable int id) {
        Teacher teacher = teacherRepository.findById(id);
        teacherRepository.delete(teacher.getId());
        return "redirect:/teachers";
    }

    @GetMapping("/editTeacher/{id}")
    public String editTeacher(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherRepository.findById(id);
        model.addAttribute("teacher", teacher);
        return "update_teacher";
    }

    @PostMapping("/updateTeacher/{id}")
    public String updateTeacher(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @PathVariable("id") int id) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacherRepository.update(id, teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/clearTeachers")
    public String clearTeachers() {
        teacherRepository.clear();
        return "redirect:/teachers";
    }
}
