package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.CourseDAO;
import org.example.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<String> getIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select programId from Course");
        List<String> list = query.getResultList();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select programId from Course ORDER BY programId desc limit 1");
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public Course getObject(String value) {
        return null;
    }

    @Override
    public boolean save(Course object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Course object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course search(String id) {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            // Corrected native query
            NativeQuery<Course> nativeQuery = session.createNativeQuery("select * from Course where programId = :id", Course.class);
            nativeQuery.setParameter("id", id);

            List<Course> list = nativeQuery.list();
            transaction.commit();
            session.close();

            return list.isEmpty() ? null : list.get(0); // Added null check to avoid IndexOutOfBoundsException
    }

    @Override
    public Course get(Course object) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("select * from Course");
        nativeQuery.addEntity(Course.class);
        List<Course> resultList = nativeQuery.getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }
}
