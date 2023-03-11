package it.kg.repositories.impl;

import it.kg.models.Company;
import it.kg.models.Course;
import it.kg.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.postgresql.core.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public void save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
//        session.createQuery("delete from Company where id="+id).executeUpdate();
        Company company = findById(id);
        session.delete(company);

//        Query query = (Query) session.createQuery("FROM Company as p LEFT JOIN FETCH  p.courses WHERE p.id="+id);
//
//        // Retrieve record
//        Company company = (Company) query.uniqueResult();
//
//        List<Course> courses = company.getCourses();
//
//        // Delete company
//        session.delete(company);
//
//        // Delete associated courses
//        for (Course course: courses) {
//            session.delete(course);
//        }
    }

    @Override
    public void update(int id, Company company) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = findById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        session.merge(company1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company ").executeUpdate();
    }
}
