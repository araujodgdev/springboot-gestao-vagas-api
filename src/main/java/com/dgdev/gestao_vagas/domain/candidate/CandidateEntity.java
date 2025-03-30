package com.dgdev.gestao_vagas.domain.candidate;


import lombok.Data;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$)", message = "O campo [username] não deve conter espaços!")
    private String username;

    @Email(message = "O campo [email] deve conter um email válido!")
    private String email;

    @Length(min = 10, max = 25)
    private String password;
    private String description;
    private String curriculum;
}
