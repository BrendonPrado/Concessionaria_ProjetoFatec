package com.fatec.ite.Concessionaria.domains.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

    private String fullName;
    private String email;
    private String cpf;
    private Integer yearsOld;
}