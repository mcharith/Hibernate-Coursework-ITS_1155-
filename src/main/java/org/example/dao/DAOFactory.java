package org.example.dao;

import org.example.dao.custom.impl.CourseDAOImpl;
import org.example.dao.custom.impl.StudentDAOImpl;
import org.example.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public enum DAOType{
        Course,User,Student
    }

    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAOType(DAOType daoType){
        switch (daoType){
            case Course:
                return new CourseDAOImpl();
            case User:
                return new UserDAOImpl();
            case Student:
                return new StudentDAOImpl();
                default:
                    return null;
        }
    }
}
