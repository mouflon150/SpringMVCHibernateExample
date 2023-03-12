package it.kg.service.impl;

import it.kg.models.Course;
import it.kg.repositories.CourseRepository;
import it.kg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public void update(int id, Course course) {
        courseRepository.update(id, course);
    }

    @Override
    public void clear() {
        courseRepository.clear();
    }
}
