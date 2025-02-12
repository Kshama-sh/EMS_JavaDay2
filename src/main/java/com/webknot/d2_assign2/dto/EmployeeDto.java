package com.webknot.d2_assign2.dto;

import lombok.*;

import jakarta.validation.constraints.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    @NotNull(message = "Name is required")
    private String name;
    @Email(message = "Invalid email format")
    private String email;
    private String role;
    private String department;
    private Set<Long> skillIds;
    private Set<Long> projectIds;
}
