package it.kg.service.impl;

import it.kg.models.Group;
import it.kg.repositories.CourseRepository;
import it.kg.repositories.GroupRepository;
import it.kg.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(int id) {
        return groupRepository.findById(id);
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(int id) {
        groupRepository.delete(id);
    }

    @Override
    public void update(int id, Group group) {
        groupRepository.update(id, group);
    }

    @Override
    public void clear() {
        groupRepository.clear();
    }
}
