package it.kg.repositories.impl;

import it.kg.models.Course;
import it.kg.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course where id=:courseId").setParameter("courseId", id).executeUpdate();

    }

    @Override
    public void updateCourse(int id, Course course) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = findById(id);
        course1.setCourseName(course1.getCourseName());
        course1.setDuration(course1.getDuration());
        session.merge(course1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course ").executeUpdate();

    }
}
