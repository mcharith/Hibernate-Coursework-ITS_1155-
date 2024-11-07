package org.example.entity.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseTm {
    private String programId;
    private String programName;
    private String duration;
    private int fee;
}
