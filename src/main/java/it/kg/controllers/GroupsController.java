package it.kg.controllers;

import it.kg.models.Company;
import it.kg.models.Course;
import it.kg.models.Group;
import it.kg.repositories.CompanyRepository;
import it.kg.repositories.CourseRepository;
import it.kg.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupsController {

    private final GroupRepository groupRepository;

    private final CourseRepository courseRepository;

    private final CompanyRepository companyRepository;

    @Autowired
    public GroupsController(GroupRepository groupRepository,
                            CompanyRepository companyRepository,
                            CourseRepository courseRepository) {
        this.groupRepository = groupRepository;
        this.companyRepository = companyRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/groups")
    public String findAllGroups(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "list_groups";
    }

    @GetMapping("/findGroup/{id}")
    public String findGroupById(Model model, @PathVariable int id) {
        Group group = groupRepository.findById(id);
        model.addAttribute("group", group);
        return "find_group";
    }

    @GetMapping("/groupForm")
    public String showGroupForm(Model model) {
        model.addAttribute("company", companyRepository.findAll());
        model.addAttribute("course", courseRepository.findAll());
        return "add_group";
    }

    @PostMapping("/addGroup")
    private String saveGroup(@RequestParam("groupName") String groupName,
                             @RequestParam("dateOfStart") String dateOfStart,
                             @RequestParam("dateOfFinish") String dateOfFinish,
                             @RequestParam("companyId") int companyId,
                             @RequestParam("courseId") int courseId
                             ) {
        List<Course> courses = new ArrayList<>();
        Company company = companyRepository.findById(companyId);
        Course course = courseRepository.findById(courseId);
        Group group = new Group();
        group.setGroupName(groupName);
        group.setDateOfStart(dateOfStart);
        group.setDateOfFinish(dateOfFinish);
        group.setCompany(company);
        courses.add(course);
        group.setCourses(courses);
        groupRepository.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteGroupById(@PathVariable int id) {
        Group group = groupRepository.findById(id);
        groupRepository.delete(group.getId());
        return "redirect:/groups";
    }

    @GetMapping("/editGroup/{id}")
    public String editGroup(@PathVariable("id") int id, Model model) {
        Group group = groupRepository.findById(id);
        model.addAttribute("group", group);
        return "update_group";
    }

    @PostMapping("/updateGroup/{id}")
    public String updateGroup(@RequestParam("groupName") String groupName,
                              @RequestParam("dateOfStart") String dateOfStart,
                              @RequestParam("dateOfFinish") String dateOfFinish,
                              @PathVariable("id") int id) {
        Group group = new Group();
        group.setGroupName(groupName);
        group.setDateOfStart(dateOfStart);
        group.setDateOfFinish(dateOfFinish);
        groupRepository.update(id, group);
        return "redirect:/groups";
    }

    @GetMapping("/clearGroups")
    public String clearGroups() {
        groupRepository.clear();
        return "redirect:/groups";
    }
}
