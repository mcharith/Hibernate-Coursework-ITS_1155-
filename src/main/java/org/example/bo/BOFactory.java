package org.example.bo;

import org.example.bo.custom.impl.CourseBOImpl;
import org.example.bo.custom.impl.StudentBOImpl;
import org.example.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public enum BOType {
        Course,User,Student;
    }
    public static BOFactory getBOFactory() {
        return boFactory == null ? new BOFactory() : boFactory;
    }
    public SuperBo getBOType(BOType boType) {
        switch (boType) {
            case Course:
                return new CourseBOImpl();
            case User:
                return new UserBOImpl();
            case Student:
                return new StudentBOImpl();
            default:
                return null;
        }
    }
}
