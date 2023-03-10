package it.kg.repositories;


import it.kg.models.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void delete(int id);

    void updateCourse(int id,Course course);

    void clear();
}
