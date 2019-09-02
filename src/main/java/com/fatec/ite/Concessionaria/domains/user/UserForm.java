package com.fatec.ite.Concessionaria.domains.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

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