package org.example.bo.custom;

import org.example.bo.SuperBo;
import org.example.dto.UserDTO;

public interface UserBO extends SuperBo{
    public boolean save(UserDTO userDTO);
}
