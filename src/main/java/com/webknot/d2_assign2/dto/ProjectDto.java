package com.webknot.d2_assign2.dto;

import lombok.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String projectName;
    private String description;
    private Set<Long> employeeIds;
}
