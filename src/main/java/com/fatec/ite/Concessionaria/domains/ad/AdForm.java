package com.fatec.ite.Concessionaria.domains.ad;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdForm {

    @NotNull
    private Integer salesManId;

    @NotNull
    private Integer carId;

    @NotNull
    @PositiveOrZero
    private double price;
}
