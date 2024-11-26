package org.example.bo.custom;

import org.example.bo.SuperBo;
import org.example.dto.UserDTO;
import org.example.entity.User;

import java.util.List;

public interface UserBO extends SuperBo{
    public boolean save(UserDTO userDTO);
    public boolean update(UserDTO userDTO);
    String getCurrentId();
    List<UserDTO>getAll();
    User searchByEmail(String email);
}
