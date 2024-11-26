package org.example.bo.custom;

import org.example.bo.SuperBo;
import org.example.dto.AdminDTO;

import java.util.List;

public interface AdminBO extends SuperBo {
    public boolean save(AdminDTO adminDTO);
    String getCurrentId();
    List<AdminDTO> getAll();
}
