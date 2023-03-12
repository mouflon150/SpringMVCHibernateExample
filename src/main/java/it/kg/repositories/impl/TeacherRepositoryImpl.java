package it.kg.repositories.impl;

import it.kg.models.Teacher;
import it.kg.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Teacher c", Teacher.class).getResultList();
    }

    @Override
    public Teacher findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
//        session.createQuery("delete from Teacher where id=:teacherId").setParameter("teacherId", id).executeUpdate();
        Teacher teacher = findById(id);
        session.delete(teacher);
    }

    @Override
    public void update(int id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        session.merge(teacher1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher ").executeUpdate();
    }
}

