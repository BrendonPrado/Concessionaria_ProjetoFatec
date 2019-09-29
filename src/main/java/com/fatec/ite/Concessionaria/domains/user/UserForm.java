package com.fatec.ite.Concessionaria.domains.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

    @Length(min = 5,max = 60)
    @NotNull
    private String fullName;

    @Email(message = "Tem que ser um email válido")
    @NotNull
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    private String cpf;

    @Positive
    private Integer yearsOld;
}