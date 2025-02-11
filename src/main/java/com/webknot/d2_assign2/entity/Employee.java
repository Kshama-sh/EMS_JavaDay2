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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Email private String email;
    private String role;
    private String department;

    @ManyToMany
    private Set<Skill> skills;

    @ManyToMany
    private Set<Project> projects;
}

