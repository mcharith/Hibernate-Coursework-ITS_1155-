package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.AdminDAO;
import org.example.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Admin object) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Admin search(String id) {
        return null;
    }

    @Override
    public Admin get(Admin object) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Admin> admins = session.createQuery("from Admin").list();
        transaction.commit();
        session.close();
        return admins;
    }

    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select userId from Admin order by userId desc limit 1");
        String userId = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return userId;
    }
}
