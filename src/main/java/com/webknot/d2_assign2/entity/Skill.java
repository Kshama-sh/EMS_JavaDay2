package com.webknot.d2_assign2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
}
