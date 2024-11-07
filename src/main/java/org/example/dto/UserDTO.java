package org.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @Id
    private String userId;
    private String userName;
    private int telephone;
    private String email;
    private String jobRole;
    private String password;
}
