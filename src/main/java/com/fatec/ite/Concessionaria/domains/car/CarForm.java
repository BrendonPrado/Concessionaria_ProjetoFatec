package com.fatec.ite.Concessionaria.domains.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class CarForm {

    @NotNull
    @NotEmpty
    @NotBlank
    private String brand;

    @NotNull
    @NotEmpty
    @NotBlank
    private String model;

    @NotNull
    @NotEmpty
    @NotBlank
    private String plate;

    @Positive
    private Integer yearOfFabrication;

    @NotNull
    private Integer userId;
}
