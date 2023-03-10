package it.kg.controllers;

import it.kg.repositories.GroupRepository;

//@Controller
public class GroupsController {
    private final GroupRepository groupsRepository;

    public GroupsController(GroupRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }
}
//    @GetMapping("/")
//    public String findAll(Model model) {
//        model.addAttribute("all", groupsRepository.findAll());
//        return "find all";
//    }
//
//    @PostMapping("/saveGroups")
//    private String saveGroups(@RequestParam("groupName") String groupName, @RequestParam("dateOfStart") int dateOfStart, @RequestParam("dateOfFinish") int dateOfFinish) {
//        Groups groups = new Groups();
//        groups.setGroupName(groupName);
//        groups.setDateOfStart(dateOfStart);
//        groups.setDateOfFinish(dateOfFinish);
//        groupsRepository.save(groups);
//        return "redirect:/";
//    }
//
//    @GetMapping("/groupsForm")
//    public String saveCoursePage() {
//        return "groups-save";
//    }
//
//
//    @GetMapping("/deleteGroups/{id}")
//    public String deleteById(@PathVariable int id) {
//        Groups groups = groupsRepository.findById(id);
//        groupsRepository.delete(groups.getId());
//        return "redirect:/";
//    }
//
//    @GetMapping("/get/by/{id}")
//    public String getById(Model model, @PathVariable int id) {
//        Groups groups = groupsRepository.findById(id);
//        model.addAttribute("groups", groups);
//        return "find";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateCourseForm(@PathVariable("id") int id, Model model) {
//        Groups groups = groupsRepository.findById(id);
//        model.addAttribute("groups", groups);
//        return "update-groups-form";
//    }
//
//    @PostMapping("/real/update/{id}")
//    public String updateGroups(@RequestParam("groupsName") String groupsName, @RequestParam("dateOfStart") int dateOfStart, @RequestParam("dateOfFinish") int dateOfFinish, @PathVariable int id) {
//        Groups groups = new Groups();
//        groups.setGroupName(groupsName);
//        groups.setDateOfStart(dateOfStart);
//        groups.setDateOfFinish(dateOfFinish);
//        groupsRepository.updateGroups(id, groups);
//        return "redirect:/";
//    }
//
//    @GetMapping("/clear")
//    public String clear() {
//        groupsRepository.clear();
//        return "redirect:/";
//    }
//}
