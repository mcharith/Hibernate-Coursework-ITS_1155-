package org.example.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {
    @Id
    private String userId;
    private String userName;
    private int telephone;
    private String email;
    private String password;
}
