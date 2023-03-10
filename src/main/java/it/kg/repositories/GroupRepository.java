package it.kg.repositories;


import it.kg.models.Group;

import java.util.List;

public interface GroupRepository {

    List<Group> findAll();

    Group findById(int id);

    void save(Group groups);

    void delete(int id);

    void update(int id, Group groups);

    void clear();
}
