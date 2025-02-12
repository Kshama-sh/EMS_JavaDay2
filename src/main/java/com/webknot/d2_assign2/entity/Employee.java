package com.webknot.d2_assign2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String role;
    private String department;

    @ManyToMany
    private Set<Skill> skills;

    @ManyToMany
    private Set<Project> projects;
}
