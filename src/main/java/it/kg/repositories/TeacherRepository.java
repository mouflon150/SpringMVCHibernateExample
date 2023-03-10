package it.kg.repositories;

import it.kg.models.Teacher;

import java.util.List;

public interface TeacherRepository {

    List<Teacher> findAll();

    Teacher findById(int id);

    void save(Teacher teacher);

    void delete(int id);

    void update(int id, Teacher teacher);

    void clear();
}
