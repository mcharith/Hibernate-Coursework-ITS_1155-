package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.User;

public interface UserDAO extends CrudDAO<User>{
    String getCurrentId();
    User searchByEmail(String email);
}
