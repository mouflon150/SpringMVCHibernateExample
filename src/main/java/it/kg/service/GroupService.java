package it.kg.service;

import it.kg.models.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group findById(int id);

    void save(Group group);

    void delete(int id);

    void update(int id, Group group);

    void clear();
}
