package it.kg.service.impl;

import it.kg.models.Teacher;
import it.kg.repositories.TeacherRepository;
import it.kg.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(int id) {
        teacherRepository.delete(id);
    }

    @Override
    public void update(int id, Teacher teacher) {
        teacherRepository.update(id, teacher);
    }

    @Override
    public void clear() {
        teacherRepository.clear();
    }
}
