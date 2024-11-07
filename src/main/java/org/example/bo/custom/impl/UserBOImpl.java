package org.example.bo.custom.impl;

import org.example.bo.custom.UserBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.UserDAO;
import org.example.dao.custom.impl.UserDAOImpl;
import org.example.dto.UserDTO;
import org.example.entity.User;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAOType(DAOFactory.DAOType.User);

    @Override
    public boolean save(UserDTO userDTO) {
        return userDAO.save(new User(userDTO.getUserId(),userDTO.getUserName(),userDTO.getTelephone(),
                userDTO.getEmail(),userDTO.getJobRole(),userDTO.getPassword()));
    }
}
