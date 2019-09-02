package com.fatec.ite.Concessionaria.domains.ad;

import com.fatec.ite.Concessionaria.domains.car.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
