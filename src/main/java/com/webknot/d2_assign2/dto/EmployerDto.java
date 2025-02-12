package com.webknot.d2_assign2.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerDto {
    private Long id;
    private String companyName;
    @Email private String contactEmail;
}
