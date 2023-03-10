package it.kg.repositories.impl;

import it.kg.models.Group;
import it.kg.repositories.GroupRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Group> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Group c", Group.class).getResultList();
    }

    @Override
    public Group findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Group.class, id);
    }

    @Override
    public void save(Group groups) {
        Session session = sessionFactory.getCurrentSession();
        session.save(groups);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group where id=:groupId").setParameter("groupId", id).executeUpdate();
    }

    @Override
    public void update(int id, Group groups) {
        Session session = sessionFactory.getCurrentSession();
        Group groups1 = findById(id);
        groups1.setGroupName(groups1.getGroupName());
        groups1.setDateOfStart(groups1.getDateOfStart());
        groups1.setDateOfFinish(groups1.getDateOfFinish());
        session.merge(groups1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group ").executeUpdate();
    }
}
