package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.UserDAO;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public boolean delete(User object) {
        return false;
    }

    @Override
    public User search(String id) {
        return null;
    }

    @Override
    public User get(User object) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}
