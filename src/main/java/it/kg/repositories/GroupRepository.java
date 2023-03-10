package it.kg.repositories;


import it.kg.models.Groups;

import java.util.List;

public interface GroupRepository {
    List<Groups> findAll();

    Groups findById(int id);

    void save(Groups groups);

    void delete(int id);

    void updateGroups(int id, Groups groups);

    void clear();
}
