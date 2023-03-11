package it.kg.service;

import it.kg.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void delete(int id);

    void update(int id, Student student);

    void clear();
}
