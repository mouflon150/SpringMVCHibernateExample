package it.kg.service;

import it.kg.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(int id);

    void save(Teacher teacher);

    void delete(int id);

    void update(int id, Teacher teacher);

    void clear();
}
