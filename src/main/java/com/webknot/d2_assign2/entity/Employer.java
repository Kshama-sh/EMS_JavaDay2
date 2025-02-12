package com.webknot.d2_assign2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "employers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    @Email private String contactEmail;
}
