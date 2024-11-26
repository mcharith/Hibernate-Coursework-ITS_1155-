package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.PaymentDAO;
import org.example.entity.Payment;
import org.example.entity.Register;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    int paidAmount =  0;
    int fullFee = 0;
    int newBalance = 0;

    @Override
    public String getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select paymentId from Payment order by paymentId desc limit 1");
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public int getPaidAmountByRegisterId(Register registerId) {
       try (Session session = FactoryConfiguration.getInstance().getSession()){
           String hql = "SELECT r.advanced FROM Register r WHERE r.registerId = :registerId";
           Query<Integer> query = session.createQuery(hql, Integer.class);
           query.setParameter("registerId", registerId.getRegisterId());
           paidAmount = (int) query.uniqueResult();
       }catch (Exception e){
           e.printStackTrace();
       }
       return paidAmount;
    }

    @Override
    public int getFullFeeByRegisterId(Register selectedRegisterId) {
        try (Session session = FactoryConfiguration.getInstance().getSession()){
            String hql = "Select cour.fee from Register reg Join reg.course cour where reg.registerId = :registerId";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("registerId", selectedRegisterId.getRegisterId());
            fullFee = query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fullFee;
    }

    @Override
    public int getRemainingAmountByRegisterId(Register selectedRegisterId) {
        int remainingAmount = fullFee - paidAmount;
        return remainingAmount;
    }
    @Override
    public boolean save(Object object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


    @Override
    public Object search(String id) {
        return null;
    }

    @Override
    public Object get(Object object) {
        return null;
    }

    @Override
    public List getAll() {
        return List.of();
    }
}