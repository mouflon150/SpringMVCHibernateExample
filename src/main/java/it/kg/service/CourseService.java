package it.kg.service;

import it.kg.models.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void delete(int id);

    void update(int id,Course course);

    void clear();
}
