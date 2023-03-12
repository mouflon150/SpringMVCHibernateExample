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
//        session.createQuery("delete from Group where id=:groupId").setParameter("groupId", id).executeUpdate();
        Group group = findById(id);
        session.delete(group);
    }

    @Override
    public void update(int id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group group1 = findById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        session.merge(group1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group ").executeUpdate();
    }
}
